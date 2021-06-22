package com.lin.missyou.core.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName: HalfUpRound
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2216:24
 * @Version: 1.0
 */
public class HalfUpRound implements IMoneyDiscount{
    @Override
    public BigDecimal discount(BigDecimal original, BigDecimal discount) {
        BigDecimal actualMoney = original.multiply(discount);
        BigDecimal finalMoney = actualMoney.setScale(2, RoundingMode.HALF_UP);
        return finalMoney;
    }
}
