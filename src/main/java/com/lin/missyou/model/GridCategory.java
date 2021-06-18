package com.lin.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @ClassName: GridCategory
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 8:53
 * @Version: 1.0
 */
@Entity
@Setter
@Getter
@Table(name = "grid_category", schema = "missyou", catalog = "")
@Where( clause = "delete_time is null")
public class GridCategory extends Base{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String img;
    private String name;
    private Long categoryId;
    private Long rootCategoryId;

}
