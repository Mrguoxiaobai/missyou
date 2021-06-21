package com.lin.missyou.service;

import com.lin.missyou.model.Theme;

import java.util.List;
import java.util.Optional;

/**
 * The interface Theme service.
 *
 * @ClassName: ThemeService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-17 9:38
 * @Version: 1.0
 */
public interface ThemeService {
    /**
     * Gets by names.
     *
     * @param names the names
     * @return the by names
     */
    List<Theme> getByNames(List<String> names);

    /**
     * Gets by name.
     *
     * @param name the name
     * @return the by name
     */
    Optional<Theme> getByName(String name);
}
