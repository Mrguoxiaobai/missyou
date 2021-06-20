package com.lin.missyou.repository;

import com.lin.missyou.model.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @ClassName: UserCouponRepository
 * @Author: Mrguo
 * @Description:
 * @Date: 2021/6/2015:30
 * @Version: 1.0
 */
public interface UserCouponRepository extends JpaRepository<UserCoupon,Long> {
    Optional<UserCoupon> findFirstByUserIdAndCouponId(Long uid, Long couponId);
}
