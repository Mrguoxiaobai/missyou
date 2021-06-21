package com.lin.missyou.service;

import com.lin.missyou.model.Category;
import com.lin.missyou.model.Coupon;

import java.util.List;

/**
 * The interface Coupon service.
 *
 * @ClassName: com.lin.missyou.service
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021 /6/18
 * @Version: 1.0
 */
public interface CouponService {
    /**
     * Gets by categroy.
     *
     * @param cid the cid
     * @return the by categroy
     */
    List<Coupon> getByCategroy(Long cid);

    /**
     * Gets whole store coupons.
     *
     * @return the whole store coupons
     */
    List<Coupon> getWholeStoreCoupons();

    /**
     * Collect one coupon.
     *
     * @param uid      the uid
     * @param couponid the couponid
     */
    void collectOneCoupon(Long uid,Long couponid);

    /**
     * Gets my available coupons.
     *
     * @param uid the uid
     * @return the my available coupons
     */
    List<Coupon> getMyAvailableCoupons(Long uid);

    /**
     * Gets my used coupons.
     *
     * @param uid the uid
     * @return the my used coupons
     */
    List<Coupon> getMyUsedCoupons(Long uid);

    /**
     * Gets my expired coupons.
     *
     * @param uid the uid
     * @return the my expired coupons
     */
    List<Coupon> getMyExpiredCoupons(Long uid);


}
