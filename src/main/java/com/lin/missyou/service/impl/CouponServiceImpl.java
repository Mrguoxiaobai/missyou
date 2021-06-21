package com.lin.missyou.service.impl;

import com.lin.missyou.core.enumeration.CouponStatus;
import com.lin.missyou.exception.http.NotFoundExecption;
import com.lin.missyou.model.Activity;
import com.lin.missyou.model.Coupon;
import com.lin.missyou.model.UserCoupon;
import com.lin.missyou.repository.ActivityRepostory;
import com.lin.missyou.repository.CouponRepostory;
import com.lin.missyou.repository.UserCouponRepository;
import com.lin.missyou.service.CouponService;
import com.lin.missyou.utils.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The type Coupon service.
 *
 * @ClassName: com.lin.missyou.service.impl
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021 /6/18
 * @Version: 1.0
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Resource
    private CouponRepostory couponRepostory;
    @Resource
    private ActivityRepostory activityRepostory;
    @Resource
    private UserCouponRepository userCouponRepository;
    @Override
    public List<Coupon> getByCategroy(Long cid) {
        Date now = new Date();
        return couponRepostory.findByCatetory(cid,now);
    }

    @Override
    public List<Coupon> getWholeStoreCoupons() {
        Date now = new Date();
        return couponRepostory.findByWholeStore(true,now);
    }

    @Override
    public void collectOneCoupon(Long uid, Long couponId) {
        couponRepostory
                .findById(couponId)
                .orElseThrow(()->new NotFoundExecption(40003));
        Activity activity = activityRepostory
                .findByCouponListId(couponId)
                .orElseThrow(() -> new NotFoundExecption(40010));
        Date now = new Date();
        Boolean isIn = CommonUtil.isInTimeLine(now, activity.getStartTime(), activity.getEndTime());
        if(!isIn){
            throw  new NotFoundExecption(40005);
        }
        Optional<UserCoupon> first = userCouponRepository.findFirstByUserIdAndCouponId(uid, couponId);
        if (first.isPresent()){
           throw  new NotFoundExecption(40006);
        }

        UserCoupon newUserCoupon = UserCoupon.builder()
                .userId(uid)
                .couponId(couponId)
                .status(CouponStatus.AVAILABLE.getValue())
                .createTime(now)
                .build();
        userCouponRepository.save(newUserCoupon);

    }

    @Override
    public List<Coupon> getMyAvailableCoupons(Long uid) {
        Date now = new Date();
        return couponRepostory.findMyAvailable(uid,now);
    }

    @Override
    public List<Coupon> getMyUsedCoupons(Long uid) {
        Date now = new Date();
        return couponRepostory.findMyUsed(uid,now);
    }

    @Override
    public List<Coupon> getMyExpiredCoupons(Long uid) {
        Date now = new Date();
        return couponRepostory.findMyExpired(uid,now);
    }


}
