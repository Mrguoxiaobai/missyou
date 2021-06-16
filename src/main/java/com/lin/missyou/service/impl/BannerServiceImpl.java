package com.lin.missyou.service.impl;

import com.lin.missyou.mode.BannerEntity;
import com.lin.missyou.repository.BannerRepostory;
import com.lin.missyou.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Mrguo
 * @create 2021-06-16 9:57
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Resource
    private BannerRepostory bannerRepostory;
    @Override
    public Optional<BannerEntity> getByName(String name) {
        return bannerRepostory.findByName(name);
    }
}
