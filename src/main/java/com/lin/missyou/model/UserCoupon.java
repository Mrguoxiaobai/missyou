package com.lin.missyou.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName: UserCoupon
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-18 15:43
 * @Version: 1.0
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCoupon {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long couponId;
    private Integer status;
    private Date createTime;
    private Long orderId;
}
