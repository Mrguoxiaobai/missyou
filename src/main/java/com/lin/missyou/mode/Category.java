package com.lin.missyou.mode;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: Category
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 7:54
 * @Version: 1.0
 */
@Entity
@Getter
@Setter
public class Category {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer isRoot;
    private Long parentId;
    private String img;
    private Integer index;
    private boolean online;
    private Integer level;

}
