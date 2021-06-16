package com.lin.missyou.mode;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "sku", schema = "missyou")
public class SkuEntity extends BaseEntity{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private boolean online;
    private String img;
    private String title;
    private Long spuId;
  /*  private Object specs;*/
    private String code;
    private int stock;
    private Long categoryId;
    private Long rootCategoryId;

}
