package com.lin.missyou.service;

import com.lin.missyou.dto.OrderDTO;
import com.lin.missyou.logic.OrderChecker;
import com.lin.missyou.model.Order;
import org.springframework.data.domain.Page;

import java.util.Optional;

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

    /**
     * Gets by status.
     *
     * @param status  the status
     * @param pageNum the page num
     * @param size    the size
     * @return the by status
     */
    Page<Order> getByStatus(Integer status, Integer pageNum, Integer size);

    /**
     * Gets unpaid.
     *
     * @param pageNum the page num
     * @param size    the size
     * @return the unpaid
     */
    Page<Order> getUnpaid(Integer pageNum, Integer size);

    /**
     * Gets order detail.
     *
     * @param oid the oid
     * @return the order detail
     */
    Optional<Order> getOrderDetail(Long oid);

    /**
     * Update order prepay id.
     *
     * @param id        the id
     * @param prepay_id the prepay id
     */
    void updateOrderPrepayId(Long id, String prepay_id);
}
