package com.lin.missyou.api.v1;

import com.lin.missyou.exception.http.NotFoundExecption;
import com.lin.missyou.model.Category;
import com.lin.missyou.model.GridCategory;
import com.lin.missyou.service.CategoryService;
import com.lin.missyou.service.GridCategoryService;
import com.lin.missyou.vo.CategoriesAllVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * The type Category controller.
 *
 * @ClassName: CategoryController
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-17 8:24
 * @Version: 1.0
 */
@RestController
@RequestMapping("/v1/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;
    @Resource
    private GridCategoryService gridCategoryService;

    /**
     * Get all categories all vo.
     *
     * @return the categories all vo
     */
    @GetMapping("/all")
    public CategoriesAllVO getAll(){
        Map<Integer, List<Category>> all = categoryService.getAll();
        return new CategoriesAllVO(all);
    }

    /**
     * Get grid all list.
     *
     * @return the list
     */
    @GetMapping("/grid/all")
    public List<GridCategory> getGridAll(){
        List<GridCategory> all = gridCategoryService.getAll();
        if(all.isEmpty()){
            throw  new NotFoundExecption(30009);
        }
        return all;
    }
}
