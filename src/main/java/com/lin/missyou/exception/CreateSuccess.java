package com.lin.missyou.exception;

import com.lin.missyou.exception.http.HttpException;

/**
 * The type Create success.
 *
 * @ClassName: CreateSuccess
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2015:44
 * @Version: 1.0
 */
public class CreateSuccess extends HttpException
{
    /**
     * Instantiates a new Create success.
     *
     * @param code the code
     */
    public CreateSuccess(int code){
        this.httpStatusCode = 201;
        this.code = code;
    }
}
