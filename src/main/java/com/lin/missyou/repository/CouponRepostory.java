package com.lin.missyou.repository;

import com.lin.missyou.model.Category;
import com.lin.missyou.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: com.lin.missyou.repository
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/18
 * @Version: 1.0
 */
public interface CouponRepostory extends JpaRepository<Coupon,Long> {
    @Query("select c from Coupon c\n" +
            "join c.categoryList ca\n" +
            "join Activity a on a.id = c.activityId\n" +
            "where ca.id = :cid\n" +
            "and a.startTime < :now\n" +
            "and a.endTime > :now\n")
    List<Coupon> findByCatetory(Long cid, Date now);

    @Query("select c from Coupon c\n" +
            "join Activity a on c.activityId = a.id\n" +
            "where c.wholeStore = :isWholeStore\n" +
            "and a.startTime < :now\n" +
            "and a.endTime > :now\n" )
    List<Coupon> findByWholeStore(boolean isWholeStore, Date now);
}
