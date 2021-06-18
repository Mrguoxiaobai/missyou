package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName: Category
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 7:54
 * @Version: 1.0
 */
@Entity
@Getter
@Setter
@Where( clause = "delete_time is null")
public class Category extends Base{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer isRoot;
    private Long parentId;
    private String img;
    private Integer index;
    private boolean online;
    private Integer level;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "coupon_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "coupon_id"))
    private List<Coupon> couponList;
}
