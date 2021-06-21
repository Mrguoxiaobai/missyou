package com.lin.missyou.repository;

import com.lin.missyou.model.Activity;
import com.lin.missyou.vo.ActivityPureVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Activity repostory.
 *
 * @ClassName: ActivityRepostory
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-18 16:08
 * @Version: 1.0
 */
public interface ActivityRepostory extends JpaRepository<Activity,Long> {
    /**
     * Find by name activity.
     *
     * @param name the name
     * @return the activity
     */
    Activity findByName(String name);

    /**
     * Find by coupon list id optional.
     *
     * @param couponId the coupon id
     * @return the optional
     */
    Optional<Activity> findByCouponListId(Long couponId);
}
