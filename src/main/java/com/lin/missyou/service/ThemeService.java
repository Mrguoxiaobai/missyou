package com.lin.missyou.service;

import com.lin.missyou.mode.Theme;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName: ThemeService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 9:38
 * @Version: 1.0
 */
public interface ThemeService {
    List<Theme> getByNames(List<String> names);
    Optional<Theme> getByName(String name);
}
