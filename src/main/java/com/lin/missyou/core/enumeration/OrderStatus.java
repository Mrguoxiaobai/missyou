package com.lin.missyou.core.enumeration;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.stream.Stream;

/**
 * The enum Order status.
 *
 * @ClassName: OrderStatus
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2217:08
 * @Version: 1.0
 */
public enum OrderStatus {
    /**
     * All order status.
     */
    All(0, "全部"),
    /**
     * Unpaid order status.
     */
    UNPAID(1, "待支付"),
    /**
     * Paid order status.
     */
    PAID(2, "已支付"),
    /**
     * Delivered order status.
     */
    DELIVERED(3, "已发货"),
    /**
     * Finished order status.
     */
    FINISHED(4, "已完成"),
    /**
     * Canceled order status.
     */
    CANCELED(5, "已取消"),

    /**
     * Paid but out of order status.
     */
// 预扣除库存不存在以下这两种情况
    PAID_BUT_OUT_OF(21, "已支付，但无货或库存不足"),
    /**
     * Deal out of order status.
     */
    DEAL_OUT_OF(22, "已处理缺货但支付的情况"),
    /**
     * Unknown order status.
     */
    UNKNOWN(-1,"未知");
    private int value;

    OrderStatus(int value, String text) {
        this.value = value;
    }

    /**
     * Value int.
     *
     * @return the int
     */
    public int value() {
        return this.value;
    }

    /**
     * To type order status.
     *
     * @param value the value
     * @return the order status
     */
    public static OrderStatus toType(Integer value) {
        return Stream.of(OrderStatus.values())
                .filter(c -> c.value == value)
                .findAny()
                .orElse(OrderStatus.UNKNOWN);
    }
}

