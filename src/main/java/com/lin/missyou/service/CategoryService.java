package com.lin.missyou.service;

import com.lin.missyou.model.Category;
import java.util.List;
import java.util.Map;

/**
 * The interface Category service.
 *
 * @ClassName: CategoryService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-17 8:16
 * @Version: 1.0
 */
public interface CategoryService {
    /**
     * Gets all.
     *
     * @return the all
     */
    public Map<Integer, List<Category>> getAll();
}
