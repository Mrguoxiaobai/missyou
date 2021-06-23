package com.lin.missyou.repository;

import com.lin.missyou.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

/**
 * The interface Order repostory.
 *
 * @ClassName: OrderRepostory
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2117:17
 * @Version: 1.0
 */
public interface OrderRepostory extends JpaRepository<Order,Long> {

    /**
     * Find by expired time greater than and status and user id page.
     *
     * @param now         the now
     * @param value       the value
     * @param uid         the uid
     * @param pageRequest the page request
     * @return the page
     */
    Page<Order> findByExpiredTimeGreaterThanAndStatusAndUserId(Date now, Integer value, Long uid, Pageable pageRequest);

    /**
     * Find by user id page.
     *
     * @param uid      the uid
     * @param pageable the pageable
     * @return the page
     */
    Page<Order> findByUserId(Long uid, Pageable pageable);

    /**
     * Find by user id and status page.
     *
     * @param uid      the uid
     * @param status   the status
     * @param
     * @return the page
     */
    Page<Order> findByUserIdAndStatus(Long uid, Integer status,  Pageable pageRequest);

    /**
     * Find first by user id and id optional.
     *
     * @param uid the uid
     * @param oid the oid
     * @return the optional
     */
    Optional<Order> findFirstByUserIdAndId(Long uid, Long oid);

    /**
     * Find first by order no optional.
     *
     * @param orderNo the order no
     * @return the optional
     */
    Optional<Order> findFirstByOrderNo(String orderNo);

    /**
     * Update status by order no int.
     *
     * @param orderNo the order no
     * @param status  the status
     * @return the int
     */
    @Modifying
    @Query("update Order o set o.status=:status where o.orderNo=:orderNo")
    int updateStatusByOrderNo(String orderNo, Integer status);

    /**
     * Cancel order int.
     *
     * @param oid the oid
     * @return the int
     */
    @Modifying
    @Query("update Order o set o.status=5 where o.status = 1 and o.id=:oid")
    int cancelOrder(Long oid);
}
