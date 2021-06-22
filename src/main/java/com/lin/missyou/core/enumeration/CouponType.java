package com.lin.missyou.core.enumeration;

import java.util.stream.Stream;

/**
 * The enum Coupon type.
 *
 * @ClassName: CouponType
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2217:05
 * @Version: 1.0
 */
public enum CouponType {
    /**
     * Full minus coupon type.
     */
    FULL_MINUS(1, "满减券"),
    /**
     * Full off coupon type.
     */
    FULL_OFF(2,"满减折扣券"),
    /**
     * No threshold minus coupon type.
     */
    NO_THRESHOLD_MINUS(3, "无门槛减除券"),
    /**
     * Unknown coupon type.
     */
    UNKNOWN(-1,"未知");

    private int value;

    CouponType(int value, String description) {
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
     * To type coupon type.
     *
     * @param value the value
     * @return the coupon type
     */
    public static CouponType toType(Integer value) {
        return Stream.of(CouponType.values())
                .filter(c -> c.value == value)
                .findAny()
                .orElse(CouponType.UNKNOWN);
    }
}

