package com.lin.missyou.mode;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

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
public class SpuEntity extends BaseEntity{
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
    private List<SkuEntity> skuList;
    @OneToMany
    @JoinColumn(name = "spuId")
    private List<SpuDetailImgEntity> spuDetailImgList;
    @OneToMany
    @JoinColumn(name = "spuId")
    private List<SpuImgEntity> spuImgList;
}
