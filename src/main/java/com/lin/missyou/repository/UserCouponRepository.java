package com.lin.missyou.repository;

import com.lin.missyou.model.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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

    /**
     * Write off int.
     *
     * @param couponId the coupon id
     * @param oid      the oid
     * @param uid      the uid
     * @return the int
     */
    @Modifying
    @Query("update UserCoupon uc\n" +
            "set uc.status = 2, uc.orderId = :oid\n" +
            "where uc.userId = :uid\n" +
            "and uc.couponId = :couponId\n" +
            "and uc.status = 1\n" +
            "and uc.orderId is null")
    int writeOff(Long couponId, Long oid, Long uid);

    /**
     * Return back.
     *
     * @param couponId the coupon id
     * @param uid      the uid
     */
    @Modifying
    @Query("update UserCoupon c \n" +
            "set c.status=1, c.orderId = null \n" +
            "where c.couponId=:couponId \n" +
            "and c.userId = :uid \n" +
            "and c.orderId is not null \n" +
            "and c.status = 2")
    void returnBack(Long couponId, Long uid);
}
