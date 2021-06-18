package com.lin.missyou.repository;

import com.lin.missyou.model.Activity;
import com.lin.missyou.vo.ActivityPureVO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName: ActivityRepostory
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-18 16:08
 * @Version: 1.0
 */
public interface ActivityRepostory extends JpaRepository<Activity,Long> {
    Activity findByName(String name);
}
