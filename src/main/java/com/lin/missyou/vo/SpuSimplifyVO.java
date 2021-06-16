package com.lin.missyou.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: com.lin.missyou.vo
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/16
 * @Version: 1.0
 */
@Setter
@Getter
public class SpuSimplifyVO {
    private Long id;
    private String title;
    private String subtitle;
    private String img;
    private String forThemeImg;
    private String price;
    private String discountPrice;
    private String description;
    private String tags;
    private String sketchSpecId;
}
