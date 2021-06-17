package com.lin.missyou.api.v1;

import com.lin.missyou.dto.TokenGetDTO;
import com.lin.missyou.exception.NotFoundExecption;
import com.lin.missyou.service.AuthenticationService;
import com.lin.missyou.service.impl.WxAuthenticationServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TokenController
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 10:51
 * @Version: 1.0
 */
@RestController
@RequestMapping("/v1/token")
public class TokenController {
    @Resource
    private AuthenticationService authenticationService;
    @PostMapping("")
    public Map<String,String> getToken(@RequestBody @Validated TokenGetDTO tokenGetDTO){
        HashMap<String, String> map = new HashMap<>();
        String token=null;
        switch (tokenGetDTO.getLoginType()){
            case USER_WX:
                token = authenticationService.code2Session(tokenGetDTO.getAccount());
                break;
            case USER_EMAIL:
                break;
            default:
                throw new NotFoundExecption(10003);
        }
        return null;
    }
}
