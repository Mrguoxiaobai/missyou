package com.lin.missyou.service;

import com.lin.missyou.dto.OrderDTO;
import com.lin.missyou.logic.OrderChecker;

/**
 * The interface Order service.
 *
 * @ClassName: OrderService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2117:18
 * @Version: 1.0
 */
public interface OrderService {
    /**
     * Is ok order checker.
     *
     * @param uid      the uid
     * @param orderDTO the order dto
     * @return the order checker
     */
    OrderChecker isOK(Long uid, OrderDTO orderDTO);

    /**
     * Place order long.
     *
     * @param uid          the uid
     * @param orderDTO     the order dto
     * @param orderChecker the order checker
     * @return the long
     */
    Long placeOrder(Long uid, OrderDTO orderDTO, OrderChecker orderChecker);
}
