package com.lin.missyou.api.v1;

import com.lin.missyou.model.Coupon;
import com.lin.missyou.service.CouponService;
import com.lin.missyou.vo.CouponCategoryVO;
import com.lin.missyou.vo.CouponPureVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
