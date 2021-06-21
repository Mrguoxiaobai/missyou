package com.lin.missyou.exception;

import com.lin.missyou.exception.http.HttpException;

/**
 * The type Delete success.
 *
 * @ClassName: CreateSuccess
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2015:44
 * @Version: 1.0
 */
public class DeleteSuccess extends HttpException
{
    /**
     * Instantiates a new Delete success.
     *
     * @param code the code
     */
    public DeleteSuccess(int code){
        this.httpStatusCode = 200;
        this.code = code;
    }
}
