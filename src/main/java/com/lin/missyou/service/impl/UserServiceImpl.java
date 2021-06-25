package com.lin.missyou.service.impl;

import com.lin.missyou.core.LocalUser;
import com.lin.missyou.model.User;
import com.lin.missyou.repository.UserRepostory;
import com.lin.missyou.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

/**
 * The type User service.
 *
 * @ClassName: com.lin.missyou.service.impl
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021 /6/17
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepostory userRepostory;
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepostory.findFirstById(id);
    }
    @Override
    public void updateUserWxInfo(Map<String, Object> wxUser) {
        Optional<User> user =this.getUserById(LocalUser.getUser().getId());
        user.get().setNickname(wxUser.get("nickName").toString());
        user.get().setWxProfile(wxUser);
        userRepostory.save(user.get());
    }

    public User createDevUser(Long uid) {
        User newUser = User.builder().unifyUid(uid).build();
        userRepostory.save(newUser);
        return newUser;
    }

    public User getUserByUnifyUid(Long uuid) {
        return userRepostory.findByUnifyUid(uuid);
    }
}
