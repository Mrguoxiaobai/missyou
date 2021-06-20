package com.lin.missyou.exception.http;

import lombok.Getter;

@Getter
public class HttpException extends  RuntimeException{
    protected Integer code;
    protected Integer httpStatusCode=500;
}
