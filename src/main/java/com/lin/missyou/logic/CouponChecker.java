package com.lin.missyou.logic;

import com.lin.missyou.core.money.IMoneyDiscount;
import com.lin.missyou.exception.http.ForbiddenException;
import com.lin.missyou.model.Coupon;
import com.lin.missyou.utils.CommonUtil;

import java.util.Date;

/**
 * @ClassName: CouponChecker
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2216:21
 * @Version: 1.0
 */
public class CouponChecker {
    private Coupon coupon;
    private IMoneyDiscount iMoneyDiscount;

    public CouponChecker(Coupon coupon, IMoneyDiscount iMoneyDiscount) {
        this.coupon = coupon;
        this.iMoneyDiscount = iMoneyDiscount;
    }
    public void isOk(){
        Date now = new Date();
        Boolean isInTimeLine = CommonUtil.isInTimeLine(now, coupon.getStartTime(), coupon.getEndTime());
        if (!isInTimeLine){
            throw new ForbiddenException(40007);
        }
    }


}
