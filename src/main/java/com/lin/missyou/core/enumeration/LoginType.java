package com.lin.missyou.core.enumeration;

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
    private final Integer code;
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
}
