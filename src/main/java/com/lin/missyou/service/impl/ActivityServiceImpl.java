package com.lin.missyou.service.impl;

import com.lin.missyou.model.Activity;
import com.lin.missyou.repository.ActivityRepostory;
import com.lin.missyou.service.ActivityService;
import com.lin.missyou.vo.ActivityPureVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: ActivityServiceImpl
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-18 16:10
 * @Version: 1.0
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityRepostory activityRepostory;
    @Override
    public Activity getByName(String name) {
        return activityRepostory.findByName(name);
    }

}
