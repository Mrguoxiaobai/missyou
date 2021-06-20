package com.lin.missyou.exception.http;

public class NotFoundExecption extends HttpException{
    public NotFoundExecption(int code) {
        this.httpStatusCode=404;
        this.code=code;
    }
}
