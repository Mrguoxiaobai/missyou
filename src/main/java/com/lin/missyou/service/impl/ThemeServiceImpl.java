package com.lin.missyou.service.impl;

import com.lin.missyou.mode.Theme;
import com.lin.missyou.repository.ThemeRepostory;
import com.lin.missyou.service.ThemeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName: ThemeServiceImpl
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 9:38
 * @Version: 1.0
 */
@Service
public class ThemeServiceImpl implements ThemeService {
    @Resource
    private ThemeRepostory themeRepostory;

    @Override
    public List<Theme> getByNames(List<String> names) {
        return themeRepostory.findByNames(names);
    }

    @Override
    public Optional<Theme> getByName(String name) {
        return themeRepostory.findByName(name);
    }
}
