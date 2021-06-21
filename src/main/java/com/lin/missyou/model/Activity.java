package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The type Activity.
 *
 * @ClassName: Activity
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-18 15:43
 * @Version: 1.0
 */
@Entity
@Getter
@Setter
@Where( clause = "delete_time is null")
public class Activity extends Base{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    //private Long activityCoverId;

    private Date startTime;
    private Date endTime;
    private String remark;
    private Boolean online;
    private String entranceImg;
    private String internalTopImg;
    private String name;
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "activity_category",
//            joinColumns = @JoinColumn(name = "activity_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id"))
//    private List<Category> categoryList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="activityId")
    private List<Coupon> couponList;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "activity_coupon",
//            joinColumns = @JoinColumn(name = "activity_id"),
//            inverseJoinColumns = @JoinColumn(name = "coupon_id"))
//    private List<Coupon> couponList;
}
