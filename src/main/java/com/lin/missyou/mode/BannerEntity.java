package com.lin.missyou.mode;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.LifecycleState;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Mrguo
 * @create 2021-06-16 10:18
 */
@Entity
@Getter
@Setter
@Table(name = "banner", schema = "missyou")
@Where( clause = "delete_time is null")
public class BannerEntity extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String title;
    private String img;
    @OneToMany
    @JoinColumn(name ="bannerId")
    private List<BannerItemEntity> items;
}
