package com.lin.missyou.repository;

import com.lin.missyou.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @ClassName: UserRepostory
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 16:17
 * @Version: 1.0
 */
public interface UserRepostory extends JpaRepository<User,Long> {
   Optional<User> findByOpenid(String openid);
   Optional<User> findFirstById(Long id);
}
