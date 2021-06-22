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
    OrderChecker isOK(Long uid, OrderDTO orderDTO);
}
