package com.lin.missyou.service.impl;

import com.lin.missyou.dto.OrderDTO;
import com.lin.missyou.dto.SkuInfoDTO;
import com.lin.missyou.exception.http.NotFoundExecption;
import com.lin.missyou.exception.http.ParameterException;
import com.lin.missyou.logic.CouponChecker;
import com.lin.missyou.model.Coupon;
import com.lin.missyou.model.Sku;
import com.lin.missyou.model.UserCoupon;
import com.lin.missyou.repository.CouponRepostory;
import com.lin.missyou.repository.UserCouponRepository;
import com.lin.missyou.service.OrderService;
import com.lin.missyou.service.SkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    @Resource
    private SkuService skuService;
    @Resource
    private CouponRepostory couponRepostory;
    @Resource
    private UserCouponRepository userCouponRepository;
    @Override
    public void isOK(Long uid, OrderDTO orderDTO) {
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

        }

    }
}
