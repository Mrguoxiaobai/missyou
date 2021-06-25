package com.lin.missyou.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: OrderMessageBO
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2515:43
 * @Version: 1.0
 */
@Getter
@Setter
public class OrderMessageBO {
    private Long orderId;
    private Long couponId;
    private Long userId;
    private String message;

    public OrderMessageBO(String message) {
        this.message = message;
        this.parseId(message);
    }

    private void parseId(String message) {
        String[] temp = message.split(",");
        this.userId = Long.valueOf(temp[0]);
        this.orderId = Long.valueOf(temp[1]);
        this.couponId = Long.valueOf(temp[2]);
    }
}
