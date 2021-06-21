package com.lin.missyou.core;

import com.lin.missyou.exception.CreateSuccess;

/**
 * The type Unify response.
 */
public class UnifyResponse {
    private int code;
    private String message;
    private String request;

    /**
     * Instantiates a new Unify response.
     *
     * @param code    the code
     * @param message the message
     * @param request the request
     */
    public UnifyResponse(int code, String message, String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets request.
     *
     * @return the request
     */
    public String getRequest() {
        return request;
    }

    /**
     * Create success.
     *
     * @param code the code
     */
    public static void createSuccess(int code) {
        throw new CreateSuccess(code);
    }
}
