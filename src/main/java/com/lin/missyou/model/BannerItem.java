package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Mrguo
 * @create 2021-06-16 10:45
 */
@Entity
@Getter
@Setter
@Table(name = "banner_item", schema = "missyou")
@Where( clause = "delete_time is null")
public class BannerItem extends Base {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String img;
    private String keyword;
    private Integer type;
    private Long bannerId;
    private String name;
}
