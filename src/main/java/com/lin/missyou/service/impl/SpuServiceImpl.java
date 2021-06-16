package com.lin.missyou.service.impl;

import com.lin.missyou.mode.SpuEntity;
import com.lin.missyou.repository.SpuRepostory;
import com.lin.missyou.service.SpuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @ClassName: SpuServiceImpl
 * @Author: Mrguo
 * @Description: spu  接口实现
 * @Date: 2021-06-16 15:18
 * @Version: 1.0
 */
@Service
public class SpuServiceImpl implements SpuService {
    @Resource
    private SpuRepostory spuRepostory;
    @Override
    public Optional<SpuEntity> getSpu(Long id) {
        return spuRepostory.findById(id);
    }
}
