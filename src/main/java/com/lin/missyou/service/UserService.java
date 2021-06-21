package com.lin.missyou.service;

import com.lin.missyou.model.User;

import java.util.Optional;

/**
 * The interface User service.
 *
 * @ClassName: com.lin.missyou.service
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021 /6/17
 * @Version: 1.0
 */
public interface UserService {
    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    Optional<User> getUserById(Long id);
}
