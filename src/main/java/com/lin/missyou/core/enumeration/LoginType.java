package com.lin.missyou.core.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

/**
 * @ClassName: LoginType
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 10:58
 * @Version: 1.0
 */
public enum LoginType {
    USER_WX(0,"微信登录"),
    USER_EMAIL(1,"邮箱登录");
    private Integer value;

    LoginType(Integer value, String description) {
        this.value = value;
    }
    /*private final Integer code;
    private final String info;

    LoginType(Integer code, String info) {
        this.code = code;
        this.info=info;
    }
    public Integer getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }

   *//* // 自定义反序列函数
    // JsonCreator.Mode.DELEGATING： 接收单个值，将接收的值整个传入自定义函数
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static LoginType get(Integer code) {
        if (code == null) return UNKNOWN;
        return Arrays.stream(LoginType.values()).filter(i -> i.getCode() == code.intValue()).findAny().orElse(UNKNOWN);

    }*/
}
