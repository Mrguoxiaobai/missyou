package com.lin.missyou.service.impl;

import com.lin.missyou.model.Category;
import com.lin.missyou.model.Coupon;
import com.lin.missyou.repository.CouponRepostory;
import com.lin.missyou.service.CouponService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: com.lin.missyou.service.impl
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/18
 * @Version: 1.0
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Resource
    private CouponRepostory couponRepostory;
    @Override
    public List<Coupon> getByCategroy(Long cid) {
        Date now = new Date();
        return couponRepostory.findByCatetory(cid,now);
    }
}
