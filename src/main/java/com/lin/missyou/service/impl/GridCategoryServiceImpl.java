package com.lin.missyou.service.impl;

import com.lin.missyou.model.GridCategory;
import com.lin.missyou.repository.GridCategoryRepostory;
import com.lin.missyou.service.GridCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * The type Grid category service.
 *
 * @ClassName: GridCategoryServiceImpl
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-17 8:56
 * @Version: 1.0
 */
@Service
public class GridCategoryServiceImpl implements GridCategoryService {
    /**
     * The Grid category repostory.
     */
    @Resource
    GridCategoryRepostory gridCategoryRepostory;
    @Override
    public List<GridCategory> getAll() {
        return gridCategoryRepostory.findAll();
    }
}
