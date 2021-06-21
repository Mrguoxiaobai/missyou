package com.lin.missyou.core.enumeration;

import com.lin.missyou.exception.http.ParameterException;

import java.util.stream.Stream;

/**
 * @ClassName: CouponStatus
 * @Author: Mrguo
 * @Description:
 * @Date: 2021/6/2015:36
 * @Version: 1.0
 */
public enum CouponStatus {
    AVAILABLE(1, "可以使用,未过期"),
    USED(2, "已使用"),
    EXPIRED(3, "未使用，已过期"),
    UNKNOWN(-1,"未知");

    private Integer value;

    public Integer getValue() {
        return this.value;
    }

    CouponStatus(Integer value, String description) {
        this.value =value;
    }

    public static CouponStatus toType(Integer value) {
        return Stream.of(CouponStatus.values())
                .filter(c -> c.value == value)
                .findAny()
                .orElse(CouponStatus.UNKNOWN);
    }
}
