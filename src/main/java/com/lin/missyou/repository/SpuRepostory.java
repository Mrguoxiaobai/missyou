package com.lin.missyou.repository;

import com.lin.missyou.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Spu repostory.
 *
 * @ClassName: SpuRepostory
 * @Author: Mrguo
 * @Description: spu repostory
 * @Date: 2021 -06-16 15:19
 * @Version: 1.0
 */
public interface SpuRepostory extends JpaRepository<Spu,Long> {
    /**
     * Find by category id page.
     *
     * @param id       the id
     * @param pageable the pageable
     * @return the page
     */
    Page<Spu> findByCategoryId(Long id, Pageable pageable);

    /**
     * Find by root category id page.
     *
     * @param id       the id
     * @param pageable the pageable
     * @return the page
     */
    Page<Spu> findByRootCategoryId(Long id, Pageable pageable);
}
