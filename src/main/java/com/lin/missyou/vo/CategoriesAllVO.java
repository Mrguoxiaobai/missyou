package com.lin.missyou.vo;

import com.lin.missyou.mode.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: CategoriesAllVO
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 7:59
 * @Version: 1.0
 */
@Getter
@Setter
public class CategoriesAllVO {
    private List<CategoryPureVO> roots;
    private List<CategoryPureVO> sbus;

    public CategoriesAllVO(Map<Integer,List<Category>> map) {
        this.roots = map.get(1).stream().map(CategoryPureVO::new).collect(Collectors.toList());
        this.sbus =map.get(2).stream().map(CategoryPureVO::new).collect(Collectors.toList());
    }
}
