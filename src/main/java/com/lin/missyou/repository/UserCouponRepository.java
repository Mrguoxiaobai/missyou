package com.lin.missyou.repository;

import com.lin.missyou.model.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface User coupon repository.
 *
 * @ClassName: UserCouponRepository
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2015:30
 * @Version: 1.0
 */
public interface UserCouponRepository extends JpaRepository<UserCoupon,Long> {
    /**
     * Find first by user id and coupon id optional.
     *
     * @param uid      the uid
     * @param couponId the coupon id
     * @return the optional
     */
    Optional<UserCoupon> findFirstByUserIdAndCouponId(Long uid, Long couponId);

    /**
     * Find first by user id and coupon id and status optional.
     *
     * @param uid      the uid
     * @param couponId the coupon id
     * @param status   the status
     * @return the optional
     */
    Optional<UserCoupon> findFirstByUserIdAndCouponIdAndStatus(Long uid,Long couponId ,int status);
}
