package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassName: Order
 * @Author: Mrguo
 * @Description:
 * @Date: 2021/6/2117:15
 * @Version: 1.0
 */
@Entity
@Getter
@Setter
@Where( clause = "delete_time is null")
@Table(name = "`Order`")
public class Order extends Base{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNo;
    private Long userId;
    private BigDecimal totalPrice;
    private Integer totalCount;
    private Date expiredTime;
    private Date placedTime;
    private String snapImg;
    private String snapTitle;
 /*   private Object snapItems;
    private Object snapAddress;*/
    private String prepayId;
    private BigDecimal finalTotalPrice;
    private Integer status;

}
