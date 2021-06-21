package com.lin.missyou.service;

import com.lin.missyou.model.Spu;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * The interface Spu service.
 *
 * @ClassName: SpuService
 * @Author: Mrguo
 * @Description: spu service 接口
 * @Date: 2021 -06-16 15:17
 * @Version: 1.0
 */
public interface SpuService {
    /**
     * Gets spu.
     *
     * @param id the id
     * @return the spu
     */
    Optional<Spu> getSpu(Long id);

    /**
     * Gets latest paging spu.
     *
     * @param pageNum the page num
     * @param size    the size
     * @return the latest paging spu
     */
    Page<Spu> getLatestPagingSpu(Integer pageNum, Integer size);

    /**
     * Gets by category id.
     *
     * @param id      the id
     * @param isRoot  the is root
     * @param pageNum the page num
     * @param size    the size
     * @return the by category id
     */
    Page<Spu> getByCategoryId(Long id, boolean isRoot, Integer pageNum, Integer size);

}
