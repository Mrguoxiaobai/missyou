package com.lin.missyou.mode;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

/**
 * @author Mrguo
 * @create 2021-06-16 10:45
 */
@Entity
@Getter
@Setter
@Table(name = "banner_item", schema = "missyou", catalog = "")
public class BannerItemEntity extends BaseEntity{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String img;
    private String keyword;
    private short type;
    private int bannerId;
    private String name;
}
