package com.lin.missyou.api.v1;

import com.lin.missyou.core.annotations.ScopeLevel;
import com.lin.missyou.dto.SuccessDTO;
import com.lin.missyou.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName: UserController
 * @Author: Mrguo
 * @Description:
 * @Date: 2021/6/2518:54
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/wx_info")
    @ScopeLevel
    public SuccessDTO updateUserInfo(@RequestBody Map<String,Object> user) {
        userService.updateUserWxInfo(user);
        return new SuccessDTO();
    }
}

