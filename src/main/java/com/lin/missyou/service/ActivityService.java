package com.lin.missyou.service;

import com.lin.missyou.model.Activity;
import com.lin.missyou.vo.ActivityCouponVO;
import com.lin.missyou.vo.ActivityPureVO;

/**
 * The interface Activity service.
 *
 * @ClassName: ActivityService
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 -06-18 16:09
 * @Version: 1.0
 */
public interface ActivityService {
    /**
     * Gets by name.
     *
     * @param name the name
     * @return the by name
     */
    Activity getByName(String name);
}
