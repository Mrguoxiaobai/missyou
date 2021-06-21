package com.lin.missyou.exception.http;

/**
 * The type Un authentication exception.
 *
 * @ClassName: com.lin.missyou.exception
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021 /6/17
 * @Version: 1.0
 */
public class UnAuthenticationException extends ForbiddenException{
    /**
     * Instantiates a new Un authentication exception.
     *
     * @param code the code
     */
    public UnAuthenticationException(int code) {
        super(code);
        this.httpStatusCode=401;
    }
}
