package com.lin.missyou.service;

import com.lin.missyou.model.Banner;

import java.util.Optional;

/**
 * The interface Banner service.
 *
 * @author Mrguo
 * @create 2021 -06-16 9:56
 */
public interface BannerService {
    /**
     * Gets by name.
     *
     * @param name the name
     * @return the by name
     */
    Optional<Banner> getByName(String name);
}
