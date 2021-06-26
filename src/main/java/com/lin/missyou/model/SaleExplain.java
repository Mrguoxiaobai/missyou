package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @ClassName: SaleExplain
 * @Author: Mrguo
 * @Description:
 * @Date: 2021/6/2518:39
 * @Version: 1.0
 */
@Entity
@Getter
@Setter
@Table(name = "sale_explain", schema = "missyou", catalog = "")
public class SaleExplain extends Base{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean fixed;
    private String text;
    private Long spuId;
    private Long index;
    private Long replaceId;


}
