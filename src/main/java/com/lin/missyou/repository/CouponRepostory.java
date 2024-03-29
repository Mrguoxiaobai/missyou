package com.lin.missyou.repository;

import com.lin.missyou.model.Category;
import com.lin.missyou.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * The interface Coupon repostory.
 *
 * @ClassName: com.lin.missyou.repository
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021 /6/18
 * @Version: 1.0
 */
public interface CouponRepostory extends JpaRepository<Coupon,Long> {
    /**
     * Find by category list.
     *
     * @param cid the cid
     * @param now the now
     * @return the list
     */
    @Query("select c from Coupon c\n" +
            "join c.categoryList ca\n" +
            "join Activity a on a.id = c.activityId\n" +
            "where ca.id = :cid\n" +
            "and a.startTime < :now\n" +
            "and a.endTime > :now\n")
    List<Coupon> findByCatetory(Long cid, Date now);

    /**
     * Find by whole store list.
     *
     * @param isWholeStore the is whole store
     * @param now          the now
     * @return the list
     */
    @Query("select c from Coupon c\n" +
            "join Activity a on c.activityId = a.id\n" +
            "where c.wholeStore = :isWholeStore\n" +
            "and a.startTime < :now\n" +
            "and a.endTime > :now\n" )
    List<Coupon> findByWholeStore(boolean isWholeStore, Date now);

    /**
     * Find my available list.
     *
     * @param uid the uid
     * @param now the now
     * @return the list
     */
    @Query("select c from Coupon c\n" +
            "join UserCoupon uc\n" +
            "on c.id = uc.couponId\n" +
            "join User u\n" +
            "on u.id = uc.userId\n" +
            "where uc.status = 1 \n" +
            "and u.id = :uid\n" +
            "and c.startTime < :now\n" +
            "and c.endTime > :now\n" +
            "and uc.orderId is null")
    List<Coupon> findMyAvailable(Long uid, Date now);

    /**
     * Find my used list.
     *
     * @param uid the uid
     * @param now the now
     * @return the list
     */
    @Query("select c From Coupon c\n" +
            "join UserCoupon uc\n" +
            "on c.id = uc.couponId\n" +
            "join User u\n" +
            "on u.id = uc.userId\n" +
            "where u.id = :uid\n" +
            "and uc.status = 2\n" +
            "and uc.orderId is not null \n" +
            "and c.startTime < :now\n" +
            "and c.endTime > :now")
    List<Coupon> findMyUsed(Long uid, Date now);

    /**
     * Find my expired list.
     *
     * @param uid the uid
     * @param now the now
     * @return the list
     */
    @Query("select c From Coupon c\n" +
            "join UserCoupon uc\n" +
            "on c.id = uc.couponId\n" +
            "join User u\n" +
            "on u.id = uc.userId\n" +
            "where u.id = :uid\n" +
            "and uc.orderId is null\n" +
            "and uc.status <> 2\n" +
            "and c.endTime < :now")
    List<Coupon> findMyExpired(Long uid, Date now);
}
