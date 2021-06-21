package com.lin.missyou.exception.http;

import lombok.Getter;

/**
 * The type Http exception.
 */
@Getter
public class HttpException extends  RuntimeException{
    /**
     * The Code.
     */
    protected Integer code;
    /**
     * The Http status code.
     */
    protected Integer httpStatusCode=500;
}
