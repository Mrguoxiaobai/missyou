package com.lin.missyou.repository;

import com.lin.missyou.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Spu repository.
 *
 * @ClassName: SpuRepository
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2518:47
 * @Version: 1.0
 */
public interface SpuRepository extends JpaRepository<Spu, Long> {
    /**
     * Find one by id spu.
     *
     * @param id the id
     * @return the spu
     */
    Spu findOneById(Long id);

    /**
     * Find by category id order by create time desc page.
     *
     * @param cid      the cid
     * @param pageable the pageable
     * @return the page
     */
    Page<Spu> findByCategoryIdOrderByCreateTimeDesc(Long cid, Pageable pageable);

    /**
     * Find by id in list.
     *
     * @param ids the ids
     * @return the list
     */
    List<Spu> findByIdIn(List<Long> ids);

    /**
     * Find by root category id order by create time page.
     *
     * @param cid      the cid
     * @param pageable the pageable
     * @return the page
     */
    Page<Spu> findByRootCategoryIdOrderByCreateTime(Long cid, Pageable pageable);

    /**
     * Find by title like or subtitle like page.
     *
     * @param keyword  the keyword
     * @param keyword1 the keyword 1
     * @param pageable the pageable
     * @return the page
     */
    Page<Spu> findByTitleLikeOrSubtitleLike(String keyword, String keyword1, Pageable pageable);
//    "select * from spu where category_id = cid"
//    "or and like order by >  <"
}

