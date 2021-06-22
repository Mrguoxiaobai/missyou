package com.lin.missyou.service;

import com.lin.missyou.model.Sku;

import java.util.List;

/**
 * @ClassName: SkuService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2216:04
 * @Version: 1.0
 */
public interface SkuService {
   List<Sku> getSkuListByIds(List<Long> ids);
}
