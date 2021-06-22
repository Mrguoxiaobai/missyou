package com.lin.missyou.logic;

import com.lin.missyou.bo.SkuOrderBO;
import com.lin.missyou.core.enumeration.CouponType;
import com.lin.missyou.core.money.IMoneyDiscount;
import com.lin.missyou.exception.http.ForbiddenException;
import com.lin.missyou.exception.http.ParameterException;
import com.lin.missyou.model.Category;
import com.lin.missyou.model.Coupon;
import com.lin.missyou.utils.CommonUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Coupon checker.
 *
 * @ClassName: CouponChecker
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-2216:21
 * @Version: 1.0
 */
public class CouponChecker {
    private Coupon coupon;
    private IMoneyDiscount iMoneyDiscount;

    /**
     * Instantiates a new Coupon checker.
     *
     * @param coupon         the coupon
     * @param iMoneyDiscount the money discount
     */
    public CouponChecker(Coupon coupon, IMoneyDiscount iMoneyDiscount) {
        this.coupon = coupon;
        this.iMoneyDiscount = iMoneyDiscount;
    }

    /**
     * Is ok.
     */
    public void isOk(){
        Date now = new Date();
        Boolean isInTimeLine = CommonUtil.isInTimeLine(now, coupon.getStartTime(), coupon.getEndTime());
        if (!isInTimeLine){
            throw new ForbiddenException(40007);
        }
    }

    /**
     * Final total price is ok.
     *
     * @param orderFinalTotalPrice the order final total price
     * @param serverTotalPrice     the server total price
     */
    public void finalTotalPriceIsOk(BigDecimal orderFinalTotalPrice,BigDecimal serverTotalPrice){
        BigDecimal serverFinalTotalPrice;
        switch (CouponType.toType(this.coupon.getType())){
            case FULL_MINUS:
            case NO_THRESHOLD_MINUS:
                serverFinalTotalPrice=serverTotalPrice.subtract(coupon.getMinus());
                if(serverFinalTotalPrice.compareTo(new BigDecimal("0"))<=0){
                    throw new ForbiddenException(50008);
                }
                break;
            case FULL_OFF:
                serverFinalTotalPrice = iMoneyDiscount.discount(serverTotalPrice, coupon.getRate());
                break;
            default:
                throw new ParameterException(40009);
        }
        int  compare = serverFinalTotalPrice.compareTo(orderFinalTotalPrice);
        if(compare!=0){
            throw new ForbiddenException(50008);
        }
    }

    /**
     * Can be used.
     *
     * @param skuOrderBOS      the sku order bos
     * @param serverTotalPrice the server total price
     */
    public void canBeUsed (List<SkuOrderBO> skuOrderBOS, BigDecimal serverTotalPrice){
        BigDecimal orderCategoryPrice;
        if(coupon.getWholeStore()){
            orderCategoryPrice=serverTotalPrice;
        }else {
            List<Long> cidList = coupon.getCategoryList()
                    .stream()
                    .map(Category::getId)
                    .collect(Collectors.toList());
            orderCategoryPrice=getSumByCategoryList(skuOrderBOS,cidList);
        }
        couponCanBeUsed(orderCategoryPrice);
    }

    private void couponCanBeUsed(BigDecimal orderCategoryPrice) {
        switch (CouponType.toType(this.coupon.getType())){
            case FULL_OFF:
            case FULL_MINUS:
                int compare = coupon.getFullMoney().compareTo(orderCategoryPrice);
                if(compare>0){
                    throw new ParameterException(40008);
                }
                break;
            case NO_THRESHOLD_MINUS:
                break;
            default:
                throw new ParameterException(40009);
        }
    }

    private BigDecimal getSumByCategoryList(List<SkuOrderBO> skuOrderBOS, List<Long> cidList) {
        BigDecimal sum = cidList.stream()
                .map(cid -> getSumByCategory(skuOrderBOS, cid))
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0"));
        return sum;
    }

    private BigDecimal getSumByCategory(List<SkuOrderBO> skuOrderBOS, Long cid) {
        BigDecimal sum = skuOrderBOS.stream()
                .filter(sku -> sku.getCategoryId().equals(cid))
                .map(SkuOrderBO::getActualPrice)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0"));
        return sum;
    }


}
