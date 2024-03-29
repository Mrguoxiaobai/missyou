package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName: SpuEntity
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-16 14:34
 * @Version: 1.0
 */
@Entity
@Getter
@Setter
@Table(name = "spu", schema = "missyou")
@Where( clause = "delete_time is null and online=1")
public class Spu extends Base {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subtitle;
    private Long categoryId;
    private Long rootCategoryId;
    private boolean online;
    private String price;
    private Long sketchSpecId;
    private Long defaultSkuId;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private boolean isTest;
   /* private Object spuThemeImg;*/
    private String forThemeImg;

    @OneToMany
    @JoinColumn(name = "spuId")
    private List<Sku> skuList;
    @OneToMany
    @JoinColumn(name = "spuId")
    private List<SpuDetailImg> spuDetailImgList;
    @OneToMany
    @JoinColumn(name = "spuId")
    private List<SpuImg> spuImgList;
}
