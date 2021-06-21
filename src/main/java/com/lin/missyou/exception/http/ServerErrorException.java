package com.lin.missyou.exception.http;

/**
 * The type Server error exception.
 *
 * @ClassName: com.lin.missyou.exception
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021 /6/16
 * @Version: 1.0
 */
public class ServerErrorException extends HttpException{
    /**
     * Instantiates a new Server error exception.
     *
     * @param code the code
     */
    public  ServerErrorException(int code){
        this.code=code;
    }
}
