package com.lin.missyou.service;

import com.lin.missyou.bo.OrderMessageBO;
import com.lin.missyou.exception.http.ServerErrorException;
import com.lin.missyou.model.Order;
import com.lin.missyou.repository.OrderRepostory;
import com.lin.missyou.repository.SkuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @ClassName: orderCancelService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2515:37
 * @Version: 1.0
 */
@Service
public class orderCancelService {
    @Resource
    private OrderRepostory orderRepository;

    @Resource
    private SkuRepository skuRepository;

    @Transactional(rollbackFor = Exception.class)
    public void cancel(OrderMessageBO messageBO) {
        if (messageBO.getOrderId() <= 0) {
            throw new ServerErrorException(9999);
        }
        this.cancel(messageBO.getOrderId());
    }

    private void cancel(Long oid) {
        Optional<Order> orderOptional = orderRepository.findById(oid);
        Order order = orderOptional.orElseThrow(() ->
                new ServerErrorException(9999));
        int res = orderRepository.cancelOrder(oid);
        if (res != 1) {
            return;
        }
        order.getSnapItems().forEach(i -> {
            skuRepository.recoverStock(i.getId(), i.getCount().longValue());
        });
    }
}
