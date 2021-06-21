package com.lin.missyou.repository;

import com.lin.missyou.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface User repostory.
 *
 * @ClassName: UserRepostory
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-17 16:17
 * @Version: 1.0
 */
public interface UserRepostory extends JpaRepository<User,Long> {
   /**
    * Find by openid optional.
    *
    * @param openid the openid
    * @return the optional
    */
   Optional<User> findByOpenid(String openid);

   /**
    * Find first by id optional.
    *
    * @param id the id
    * @return the optional
    */
   Optional<User> findFirstById(Long id);
}
