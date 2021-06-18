package com.lin.missyou.service.impl;

import com.lin.missyou.model.Spu;
import com.lin.missyou.repository.SpuRepostory;
import com.lin.missyou.service.SpuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Optional<Spu> getSpu(Long id) {
        return spuRepostory.findById(id);
    }

    @Override
    public Page<Spu> getLatestPagingSpu(Integer pageNum, Integer size) {
        PageRequest pageRequest = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        return spuRepostory.findAll(pageRequest);
    }

    @Override
    public Page<Spu> getByCategoryId(Long id, boolean isRoot, Integer pageNum, Integer size) {
        PageRequest pageRequest = PageRequest.of(pageNum, size);
        if(isRoot){
            return spuRepostory.findByRootCategoryId(id,pageRequest);
        }else {
            return spuRepostory.findByCategoryId(id,pageRequest);
        }

    }
}
