package com.lin.missyou.core.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

/**
 * The enum Login type.
 *
 * @ClassName: LoginType
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-17 10:58
 * @Version: 1.0
 */
public enum LoginType {
    /**
     * User wx login type.
     */
    USER_WX(0,"微信登录"),
    /**
     * User email login type.
     */
    USER_EMAIL(1,"邮箱登录");
    private Integer value;

    LoginType(Integer value, String description) {
        this.value = value;
    }
}
