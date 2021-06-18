package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "spu_detail_img", schema = "missyou")
@Where( clause = "delete_time is null")
public class SpuDetailImg extends Base {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String img;
    private Long spuId;
    private Long index;


}
