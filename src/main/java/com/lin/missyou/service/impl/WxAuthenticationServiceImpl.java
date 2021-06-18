package com.lin.missyou.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.missyou.exception.ParameterException;
import com.lin.missyou.model.User;
import com.lin.missyou.repository.UserRepostory;
import com.lin.missyou.service.AuthenticationService;
import com.lin.missyou.utils.JwtToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName: WxAuthenticationServiceImpl
 * @Author: Mrguo
 * @Description:
 * @Date: 2021-06-17 14:43
 * @Version: 1.0
 */
@Service
public class WxAuthenticationServiceImpl implements AuthenticationService {
    @Resource
    private ObjectMapper mapper;
    @Resource
    private UserRepostory userRepostory;
    @Value("${wx.code2session}")
    private String code2SessonUrl;
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.appsecret}")
    private String appsecret;
    public String code2Session(String code){
        RestTemplate ret = new RestTemplate();
        String url=MessageFormat.format(this.code2SessonUrl,this.appid,this.appsecret,code);
        Map<String, Object> session = new HashMap<>();
        String sessionText = ret.getForObject(url, String.class);
        System.out.println(sessionText);
        try {
            session = mapper.readValue(sessionText, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return this.registerUser(session);
    }
    public String registerUser(Map<String,Object> session){
        String openid = (String) session.get("openid");
        if(openid==null){
            throw new ParameterException(20004);
        }
        Optional<User> op = userRepostory.findByOpenid(openid);
        if(op.isPresent()){
            return JwtToken.makeToken(op.get().getId());
        }
        User user= User.builder().openid(openid).build();
        userRepostory.save(user);
        return JwtToken.makeToken(op.get().getId());
    }
}
