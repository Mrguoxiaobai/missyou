package com.lin.missyou.repository;

import com.lin.missyou.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Sku repository.
 *
 * @ClassName: SkuRepository
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-2216:07
 * @Version: 1.0
 */
public interface SkuRepository extends JpaRepository<Sku,Long> {
    /**
     * Find all by id list.
     *
     * @param ids the ids
     * @return the list
     */
    List<Sku> findAllByIdIn(List<Long> ids);
}
