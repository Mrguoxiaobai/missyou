package com.lin.missyou.service;

import com.lin.missyou.bo.OrderMessageBO;
import com.lin.missyou.core.enumeration.OrderStatus;
import com.lin.missyou.exception.http.ServerErrorException;
import com.lin.missyou.model.Order;
import com.lin.missyou.repository.OrderRepostory;
import com.lin.missyou.repository.UserCouponRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @ClassName: couponBackService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2515:37
 * @Version: 1.0
 */
@Service
public class couponBackService {
    @Resource
    private OrderRepostory orderRepository;

    @Resource
    private UserCouponRepository userCouponRepository;

    @Transactional(rollbackFor = Exception.class)
    public void returnBack(OrderMessageBO bo) {
        Long couponId = bo.getCouponId();
        Long uid = bo.getUserId();
        Long orderId = bo.getOrderId();

        if (couponId == -1) {
            return;
        }

        Optional<Order> optional = orderRepository.findFirstByUserIdAndId(uid, orderId);
        Order order = optional.orElseThrow(() ->new ServerErrorException(9999));

        if (order.getStatusEnum().equals(OrderStatus.UNPAID)
                || order.getStatusEnum().equals(OrderStatus.CANCELED)) {
            this.userCouponRepository.returnBack(couponId, uid);
        }
    }
}
