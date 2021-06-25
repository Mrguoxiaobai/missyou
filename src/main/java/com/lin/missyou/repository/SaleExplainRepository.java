package com.lin.missyou.repository;

import com.lin.missyou.model.SaleExplain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Sale explain repository.
 *
 * @ClassName: SaleExplainRepository
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2518:43
 * @Version: 1.0
 */
@Repository
public interface SaleExplainRepository extends JpaRepository<SaleExplain, Long> {
    /**
     * Find by fixed order by index list.
     *
     * @param fixed the fixed
     * @return the list
     */
    List<SaleExplain> findByFixedOrderByIndex(Boolean fixed);
}
