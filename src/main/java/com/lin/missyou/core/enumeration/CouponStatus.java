package com.lin.missyou.core.enumeration;

import com.lin.missyou.exception.http.ParameterException;

import java.util.stream.Stream;

/**
 * The enum Coupon status.
 *
 * @ClassName: CouponStatus
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2015:36
 * @Version: 1.0
 */
public enum CouponStatus {
    /**
     * Available coupon status.
     */
    AVAILABLE(1, "可以使用,未过期"),
    /**
     * Used coupon status.
     */
    USED(2, "已使用"),
    /**
     * Expired coupon status.
     */
    EXPIRED(3, "未使用，已过期"),
    /**
     * Unknown coupon status.
     */
    UNKNOWN(-1,"未知");

    private Integer value;

    /**
     * Gets value.
     *
     * @return the value
     */
    public Integer getValue() {
        return this.value;
    }

    CouponStatus(Integer value, String description) {
        this.value =value;
    }

    /**
     * To type coupon status.
     *
     * @param value the value
     * @return the coupon status
     */
    public static CouponStatus toType(Integer value) {
        return Stream.of(CouponStatus.values())
                .filter(c -> c.value == value)
                .findAny()
                .orElse(CouponStatus.UNKNOWN);
    }
}
