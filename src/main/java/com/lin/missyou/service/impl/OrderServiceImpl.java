package com.lin.missyou.service.impl;

import com.lin.missyou.core.LocalUser;
import com.lin.missyou.core.enumeration.OrderStatus;
import com.lin.missyou.core.money.IMoneyDiscount;
import com.lin.missyou.dto.OrderDTO;
import com.lin.missyou.dto.SkuInfoDTO;
import com.lin.missyou.exception.http.ForbiddenException;
import com.lin.missyou.exception.http.NotFoundExecption;
import com.lin.missyou.exception.http.ParameterException;
import com.lin.missyou.logic.CouponChecker;
import com.lin.missyou.logic.OrderChecker;
import com.lin.missyou.model.*;
import com.lin.missyou.repository.CouponRepostory;
import com.lin.missyou.repository.OrderRepostory;
import com.lin.missyou.repository.SkuRepository;
import com.lin.missyou.repository.UserCouponRepository;
import com.lin.missyou.service.OrderService;
import com.lin.missyou.service.SkuService;
import com.lin.missyou.utils.CommonUtil;
import com.lin.missyou.utils.OrderUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Order service.
 *
 * @ClassName: OrderServiceImpl
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2117:18
 * @Version: 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Value("${missyou.order.max-sku-limit}")
    private Long maxSkuLimit;
    @Value("${missyou.order.pay-time-limit}")
    private Integer payTimeLimit;
    @Resource
    private SkuService skuService;
    @Resource
    private CouponRepostory couponRepostory;
    @Resource
    private UserCouponRepository userCouponRepository;
    @Resource
    private IMoneyDiscount iMoneyDiscount;
    @Resource
    private OrderRepostory orderRepostory;
    @Resource
    private SkuRepository skuRepository;
    @Override
    public OrderChecker isOK(Long uid, OrderDTO orderDTO) {
        if(orderDTO.getFinalTotalPrice().compareTo(new BigDecimal("0"))<=0){
            throw new ParameterException(50011);
        }
        List<Long> skuIdList = orderDTO.getSkuInfoList()
                .stream()
                .map(SkuInfoDTO::getId)
                .collect(Collectors.toList());
        List<Sku> skuList = skuService.getSkuListByIds(skuIdList);
        Long couponId = orderDTO.getCouponId();
        CouponChecker couponChecker=null;
        if(couponId!=null){
            Coupon coupon = couponRepostory.findById(couponId).orElseThrow(() -> new NotFoundExecption(40004));
            UserCoupon userCoupon = userCouponRepository.findFirstByUserIdAndCouponIdAndStatus(uid, couponId, 1).orElseThrow(() -> new NotFoundExecption(50006));
            couponChecker=new CouponChecker(coupon, iMoneyDiscount);
        }
        OrderChecker orderChecker = new OrderChecker(orderDTO, skuList, couponChecker, this.maxSkuLimit);
        orderChecker.isOK();
        return orderChecker;
    }

    @Override
    @Transactional
    public Long placeOrder(Long uid, OrderDTO orderDTO, OrderChecker orderChecker) {
        String orderNo = OrderUtil.makeOrderNo();
        Calendar now = Calendar.getInstance();
        Calendar now1 = (Calendar) now.clone();
        Date expiredTime = CommonUtil.addSomeSeconds(now, this.payTimeLimit).getTime();
        Order order = Order.builder()
                .orderNo(orderNo)
                .totalPrice(orderDTO.getTotalPrice())
                .finalTotalPrice(orderDTO.getFinalTotalPrice())
                .userId(uid)
                .totalCount(orderChecker.getTotalCount().longValue())
                .snapImg(orderChecker.getLeaderImg())
                .snapTitle(orderChecker.getLeaderTitle())
                .status(OrderStatus.UNPAID.value())
                .expiredTime(expiredTime)
                .placedTime(now1.getTime())
                .build();
        order.setSnapAddress(orderDTO.getAddress());
        order.setSnapItems(orderChecker.getOrderSkeList());
        this.orderRepostory.save(order);
        this.reduceStock(orderChecker);
        Long couponId=-1L;
        if(orderDTO.getCouponId()!=null){
            this.writeOffCoupon(orderDTO.getCouponId(),order.getId(),uid);
            couponId=orderDTO.getCouponId();
        }

        return order.getId();
    }

    @Override
    public Page<Order> getByStatus(Integer status, Integer pageNum, Integer size) {
        PageRequest pageable = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        Long uid = LocalUser.getUser().getId();
        if (status == OrderStatus.All.value()) {
            return this.orderRepostory.findByUserId(uid, pageable);
        }
        return this.orderRepostory.findByUserIdAndStatus(uid, status, pageable);
    }

    @Override
    public Page<Order> getUnpaid(Integer pageNum, Integer size) {
        PageRequest pageable = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        Long uid = LocalUser.getUser().getId();
        Date now = new Date();
        return this.orderRepostory.findByExpiredTimeGreaterThanAndStatusAndUserId(now,OrderStatus.UNPAID.value(),uid,pageable );
    }

    @Override
    public Optional<Order> getOrderDetail(Long oid) {
        Long uid = LocalUser.getUser().getId();
        return this.orderRepostory.findFirstByUserIdAndId(uid, oid);
    }


    private void writeOffCoupon(Long couponId, Long oid, Long uid) {
        int result = this.userCouponRepository.writeOff(couponId, oid, uid);
        if (result != 1) {
            throw new ForbiddenException(40012);
        }
    }
    private void reduceStock(OrderChecker orderChecker) {
        List<OrderSku> orderSkeList = orderChecker.getOrderSkeList();
        for (OrderSku orderSku:orderSkeList){
            Integer result=this.skuRepository.reduceStock(orderSku.getId(),orderSku.getCount().longValue());
            if(result!=1){
                throw new ParameterException(50003);
            }
        }
    }
}
