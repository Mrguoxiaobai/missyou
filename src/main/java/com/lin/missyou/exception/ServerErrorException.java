package com.lin.missyou.exception;

/**
 * @ClassName: com.lin.missyou.exception
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/16
 * @Version: 1.0
 */
public class ServerErrorException extends HttpException{
    public  ServerErrorException(int code){
        this.code=code;
    }
}
