package com.lin.missyou.exception;

import lombok.Getter;

@Getter
public class HttpException extends  RuntimeException{
    protected Integer code;
    protected Integer httpStatusCode=500;
}
