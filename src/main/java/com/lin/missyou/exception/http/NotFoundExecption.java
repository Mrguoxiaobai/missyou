package com.lin.missyou.exception.http;

/**
 * The type Not found execption.
 */
public class NotFoundExecption extends HttpException{
    /**
     * Instantiates a new Not found execption.
     *
     * @param code the code
     */
    public NotFoundExecption(int code) {
        this.httpStatusCode=404;
        this.code=code;
    }
}
