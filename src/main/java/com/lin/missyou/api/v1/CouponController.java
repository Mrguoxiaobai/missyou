package com.lin.missyou.api.v1;

import com.lin.missyou.core.LocalUser;
import com.lin.missyou.core.UnifyResponse;
import com.lin.missyou.core.annotations.ScopeLevel;
import com.lin.missyou.core.enumeration.CouponStatus;
import com.lin.missyou.model.Coupon;
import com.lin.missyou.service.CouponService;
import com.lin.missyou.vo.CouponCategoryVO;
import com.lin.missyou.vo.CouponPureVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: com.lin.missyou.api.v1
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/18
 * @Version: 1.0
 */
@RestController
@RequestMapping("/v1/coupon")
public class CouponController {
    @Resource
    private CouponService couponService;
    @GetMapping("/by/category/{cid}")
    public List<CouponPureVO> getCouponListByCategory(@PathVariable Long cid){
        List<Coupon> coupons = couponService.getByCategroy(cid);
        if(coupons.isEmpty()){
           return Collections.emptyList();
        }
        return CouponPureVO.getList(coupons);
    }
    @GetMapping("/whole_store")
    public List<CouponPureVO> getWholeStoreCouponList(){
        List<Coupon> coupons = couponService.getWholeStoreCoupons();
        if(coupons.isEmpty()){
            Collections.emptyList();
        }
        return CouponPureVO.getList(coupons);
    }
    @PostMapping("/collect/{id}")
    @ScopeLevel
    public void collectCoupon(@PathVariable Long id){
        final Long uid = LocalUser.getUser().getId();
        couponService.collectOneCoupon(uid,id);
        UnifyResponse.createSuccess(0);
    }

}
