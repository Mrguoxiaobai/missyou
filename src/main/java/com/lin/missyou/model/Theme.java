package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName: ThemeEntity
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-16 14:35
 * @Version: 1.0
 */
@Entity
@Setter
@Getter
@Table(name = "theme", schema = "missyou", catalog = "")
@Where( clause = "delete_time is null")
public class Theme extends Base {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String name;
    private String tplName;
    private String entranceImg;
    private String extend;
    private String internalTopImg;
    private String titleImg;
    private boolean online;
    @ManyToMany
    @JoinTable(name = "theme_spu",joinColumns = @JoinColumn(name ="theme_id"),inverseJoinColumns = @JoinColumn(name = "spu_id"))
    private List<Spu> spuList;
}
