package com.lin.missyou.core.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName: HalfEvenRound
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2216:25
 * @Version: 1.0
 */
public class HalfEvenRound implements IMoneyDiscount {
    @Override
    public BigDecimal discount(BigDecimal original, BigDecimal discount) {
        BigDecimal actualMoney = original.multiply(discount);
        BigDecimal finalMoney = actualMoney.setScale(2, RoundingMode.HALF_EVEN);
        return finalMoney;
    }
}
