package com.lin.missyou.service;

import com.lin.missyou.model.Category;
import com.lin.missyou.model.Coupon;

import java.util.List;

/**
 * @ClassName: com.lin.missyou.service
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/18
 * @Version: 1.0
 */
public interface CouponService {
    List<Coupon> getByCategroy(Long cid);

    List<Coupon> getWholeStoreCoupons();

    void collectOneCoupon(Long uid,Long couponid);
}
