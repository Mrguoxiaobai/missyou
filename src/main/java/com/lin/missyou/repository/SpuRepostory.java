package com.lin.missyou.repository;

import com.lin.missyou.mode.SpuEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName: SpuRepostory
 * @Author: Mrguo
 * @Description: spu repostory
 * @Date: 2021-06-16 15:19
 * @Version: 1.0
 */
public interface SpuRepostory extends JpaRepository<SpuEntity,Long> {
    Page<SpuEntity> findByCategoryId(Long id, Pageable pageable);
    Page<SpuEntity> findByRootCategoryId(Long id, Pageable pageable);
}
