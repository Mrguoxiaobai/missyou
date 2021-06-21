package com.lin.missyou.service;

/**
 * The interface Authentication service.
 *
 * @ClassName: AuthenticationService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-17 14:41
 * @Version: 1.0
 */
public interface AuthenticationService {
    /**
     * Code 2 session string.
     *
     * @param code the code
     * @return the string
     */
    public String code2Session(String code);
}
