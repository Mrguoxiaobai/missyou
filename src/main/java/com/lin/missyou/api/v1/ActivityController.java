package com.lin.missyou.api.v1;

import com.lin.missyou.exception.NotFoundExecption;
import com.lin.missyou.model.Activity;
import com.lin.missyou.service.ActivityService;
import com.lin.missyou.vo.ActivityPureVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: ActivityController
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-18 16:00
 * @Version: 1.0
 */
@RestController
@RequestMapping("/v1/activity")
public class ActivityController {
    @Resource
    private ActivityService activityService;
    @GetMapping("/name/{name}")
    public ActivityPureVO getHomeActivity(@PathVariable String name){
        Activity activity = activityService.getByName(name);
        if (activity==null){
            throw new NotFoundExecption(40001);
        }
        return new ActivityPureVO(activity);
    }
}
