package com.lin.missyou.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: OrderSimplifyVO
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2315:34
 * @Version: 1.0
 */
@Getter
@Setter
public class OrderSimplifyVO {
    private Long id;
    private String orderNo;
    private BigDecimal totalPrice;
    private Long totalCount;
    private String snapImg;
    private String snapTitle;
    private BigDecimal finalTotalPrice;
    private Integer status;
    private Date expiredTime;
    private Date placedTime;
    private Long period;
}