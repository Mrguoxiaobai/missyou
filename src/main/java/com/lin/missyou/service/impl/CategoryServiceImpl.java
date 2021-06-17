package com.lin.missyou.service.impl;

import com.lin.missyou.mode.Category;
import com.lin.missyou.repository.CategoryRepostory;
import com.lin.missyou.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CategoryServiceImpl
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 8:19
 * @Version: 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryRepostory categoryRepostory;
    @Override
    public Map<Integer, List<Category>> getAll() {
        List<Category> roots = categoryRepostory.findAllByIsRootOrderByIndexDesc(true);
        List<Category> subs = categoryRepostory.findAllByIsRootOrderByIndexDesc(false);
        Map<Integer, List<Category>> map = new HashMap<>();
        map.put(1, roots);
        map.put(2,subs);
        return map;
    }
}
