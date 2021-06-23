package com.lin.missyou.vo;

import com.lin.missyou.model.Order;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @ClassName: OrderPureVO
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2315:32
 * @Version: 1.0
 */
@Getter
@Setter
public class OrderPureVO extends Order {
    private Long period;
    private Date createTime;

    public OrderPureVO(Order order, Long period) {
        BeanUtils.copyProperties(order, this);
        this.period = period;
    }
}
