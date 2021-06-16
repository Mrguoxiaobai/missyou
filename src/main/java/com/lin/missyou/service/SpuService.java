package com.lin.missyou.service;

import com.lin.missyou.mode.SpuEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName: SpuService
 * @Author: Mrguo
 * @Description: spu service 接口
 * @Date: 2021-06-16 15:17
 * @Version: 1.0
 */
public interface SpuService {
    Optional<SpuEntity> getSpu(Long id);
    Page<SpuEntity> getLatestPagingSpu(Integer pageNum, Integer size);
}
