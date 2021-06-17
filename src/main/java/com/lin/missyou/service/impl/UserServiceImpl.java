package com.lin.missyou.service.impl;

import com.lin.missyou.mode.User;
import com.lin.missyou.repository.UserRepostory;
import com.lin.missyou.service.UserService;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @ClassName: com.lin.missyou.service.impl
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/17
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepostory userRepostory;
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepostory.findById(id);
    }
}
