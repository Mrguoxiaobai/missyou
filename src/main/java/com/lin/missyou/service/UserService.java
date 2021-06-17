package com.lin.missyou.service;

import com.lin.missyou.mode.User;

import java.util.Optional;

/**
 * @ClassName: com.lin.missyou.service
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/17
 * @Version: 1.0
 */
public interface UserService {
    Optional<User> getUserById(Long id);
}
