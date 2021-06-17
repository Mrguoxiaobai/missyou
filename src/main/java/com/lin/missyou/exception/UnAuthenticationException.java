package com.lin.missyou.exception;

/**
 * @ClassName: com.lin.missyou.exception
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/17
 * @Version: 1.0
 */
public class UnAuthenticationException extends ForbiddenException{
    public UnAuthenticationException(int code) {
        super(code);
        this.httpStatusCode=401;
    }
}
