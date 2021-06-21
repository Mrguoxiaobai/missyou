package com.lin.missyou.exception.http;

/**
 * The type Parameter exception.
 */
public class ParameterException extends HttpException{
    /**
     * Instantiates a new Parameter exception.
     *
     * @param code the code
     */
    public ParameterException(int code) {
        this.httpStatusCode=400;
        this.code=code;
    }
}
