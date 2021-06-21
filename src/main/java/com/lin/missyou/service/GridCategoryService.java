package com.lin.missyou.service;

import com.lin.missyou.model.GridCategory;

import java.util.List;

/**
 * The interface Grid category service.
 *
 * @ClassName: GridCategoryService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-17 8:55
 * @Version: 1.0
 */
public interface GridCategoryService {
    /**
     * Gets all.
     *
     * @return the all
     */
    public List<GridCategory> getAll();
}
