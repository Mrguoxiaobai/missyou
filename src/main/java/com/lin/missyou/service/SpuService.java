package com.lin.missyou.service;

import com.lin.missyou.mode.Spu;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * @ClassName: SpuService
 * @Author: Mrguo
 * @Description: spu service 接口
 * @Date: 2021-06-16 15:17
 * @Version: 1.0
 */
public interface SpuService {
    Optional<Spu> getSpu(Long id);
    Page<Spu> getLatestPagingSpu(Integer pageNum, Integer size);
    Page<Spu> getByCategoryId(Long id, boolean isRoot, Integer pageNum, Integer size);

}
