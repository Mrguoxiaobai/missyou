package com.lin.missyou.service.impl;

import com.lin.missyou.model.Sku;
import com.lin.missyou.repository.SkuRepository;
import com.lin.missyou.service.SkuService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: SkuServiceImpl
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-2216:06
 * @Version: 1.0
 */
public class SkuServiceImpl implements SkuService {
    @Resource
    private SkuRepository skuRepository;
    @Override
    public List<Sku> getSkuListByIds(List<Long> ids) {
        return skuRepository.findAllByIdIn(ids);
    }
}
