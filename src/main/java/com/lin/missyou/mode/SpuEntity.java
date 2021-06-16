package com.lin.missyou.mode;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
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
@Table(name = "spu", schema = "missyou", catalog = "")
public class SpuEntity extends BaseEntity{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String subtitle;
    private int categoryId;
    private Integer rootCategoryId;
    private boolean online;
    private String price;
    private Integer sketchSpecId;
    private Integer defaultSkuId;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private boolean isTest;
   /* private Object spuThemeImg;*/
    private String forThemeImg;

}
