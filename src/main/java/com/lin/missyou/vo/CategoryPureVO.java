package com.lin.missyou.vo;

import com.lin.missyou.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * @ClassName: CategoryPureVO
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 8:02
 * @Version: 1.0
 */
@Setter
@Getter
public class CategoryPureVO {
    private Long id;

    private String name;

    private Integer isRoot;

    private String img;

    private Long parentId;

    private Long index;

    public CategoryPureVO(Category category) {
        BeanUtils.copyProperties(category, this);
    }
}
