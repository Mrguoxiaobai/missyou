package com.lin.missyou.repository;

import com.lin.missyou.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    /**
     * Reduce stok int.
     *
     * @param id        the id
     * @param longValue the long value
     * @return the int
     */
    @Modifying
    @Query("update Sku s set s.stock = s.stock - (:quantity) where s.id = :sid and s.stock >= :quantity")
    Integer reduceStock(@Param("sid") Long id, @Param("quantity") Long longValue);

    /**
     * Recover stock int.
     *
     * @param sid      the sid
     * @param quantity the quantity
     * @return the int
     */
    @Modifying
    @Query("update Sku s set s.stock=s.stock+(:quantity) where s.id = :sid")
    Integer recoverStock(@Param("sid") Long sid,
                     @Param("quantity") Long quantity);


}
