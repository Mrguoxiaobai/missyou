package com.lin.missyou.core.money;

import java.math.BigDecimal;

/**
 * @ClassName: IMoneyDiscount
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2216:23
 * @Version: 1.0
 */
public interface IMoneyDiscount {
    BigDecimal discount(BigDecimal original, BigDecimal discount);
}
