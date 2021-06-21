package com.lin.missyou.exception;

import com.lin.missyou.exception.http.HttpException;

/**
 * The type Update success.
 *
 * @ClassName: CreateSuccess
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2015:44
 * @Version: 1.0
 */
public class UpdateSuccess extends HttpException
{
    /**
     * Instantiates a new Update success.
     *
     * @param code the code
     */
    public UpdateSuccess(int code){
        this.httpStatusCode = 200;
        this.code = code;
    }
}
