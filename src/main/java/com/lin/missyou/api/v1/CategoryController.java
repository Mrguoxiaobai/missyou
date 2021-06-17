package com.lin.missyou.api.v1;

import com.lin.missyou.mode.Category;
import com.lin.missyou.service.CategoryService;
import com.lin.missyou.vo.CategoriesAllVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CategoryController
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 8:24
 * @Version: 1.0
 */
@RestController
@RequestMapping("/v1/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;
    @GetMapping("/all")
    public CategoriesAllVO getAll(){
        Map<Integer, List<Category>> all = categoryService.getAll();
        System.out.println(all.get(1));
        System.out.println(all.get(2));
        return new CategoriesAllVO(all);
    }
}
