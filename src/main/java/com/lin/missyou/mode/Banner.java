package com.lin.missyou.mode;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @author Mrguo
 * @create 2021-06-16 10:18
 */
@Entity
@Getter
@Setter
@Table(name = "banner", schema = "missyou")
@Where( clause = "delete_time is null")
public class Banner extends Base {
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
    private List<BannerItem> items;
}
