package com.lin.missyou.service;

import com.lin.missyou.model.Banner;

import java.util.Optional;

/**
 * @author Mrguo
 * @create 2021-06-16 9:56
 */
public interface BannerService {
    Optional<Banner> getByName(String name);
}
