package com.lin.missyou.exception.http;

/**
 * The type Forbidden exception.
 */
public class ForbiddenException extends HttpException{
    /**
     * Instantiates a new Forbidden exception.
     *
     * @param code the code
     */
    public ForbiddenException(int code) {
        this.httpStatusCode=403;
        this.code=code;
    }
}
