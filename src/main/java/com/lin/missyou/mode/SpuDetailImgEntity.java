package com.lin.missyou.mode;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "spu_detail_img", schema = "missyou")
public class SpuDetailImgEntity extends BaseEntity{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String img;
    private Long spuId;
    private Long index;


}
