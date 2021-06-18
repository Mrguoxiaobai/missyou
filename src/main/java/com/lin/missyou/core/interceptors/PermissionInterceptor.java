package com.lin.missyou.core.interceptors;

import com.auth0.jwt.interfaces.Claim;
import com.lin.missyou.core.annotations.ScopeLevel;
import com.lin.missyou.exception.ForbiddenException;
import com.lin.missyou.exception.UnAuthenticationException;
import com.lin.missyou.service.UserService;
import com.lin.missyou.utils.JwtToken;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName: com.lin.missyou.core.interceptors
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021/6/17
 * @Version: 1.0
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<ScopeLevel> scopeLevel = this.getScopeLevel(handler);
        if(!scopeLevel.isPresent()){
            return true;
        }
        String bearerToken = request.getHeader("Authorization");
        if(StringUtils.isEmpty(bearerToken)){
            throw new UnAuthenticationException(10004);
        }
        if(!bearerToken.startsWith("Bearer")){
            throw new UnAuthenticationException(10004);
        }
        String[] tokens = bearerToken.split(" ");
        if(!(tokens.length==2)){
            throw new UnAuthenticationException(10004);
        }
        Optional<Map<String, Claim>> claims = JwtToken.getClaims(tokens[1]);
        Map<String, Claim> map = claims.orElseThrow(() -> new UnAuthenticationException(10004));
        boolean valid = this.hasPermission(scopeLevel.get(), map);

        return valid;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
    private Optional<ScopeLevel> getScopeLevel(Object handler){
        if(handler instanceof HandlerMethod){
            HandlerMethod hd=(HandlerMethod)handler;
            ScopeLevel scopeLevel = hd.getMethod().getAnnotation(ScopeLevel.class);
            if(scopeLevel==null){
                return Optional.empty();
            }
            return Optional.of(scopeLevel);
        }
        return Optional.empty();
    }
    private boolean hasPermission(ScopeLevel scopeLevel,Map<String, Claim> map){
        Integer level = scopeLevel.value();
        Integer scope = map.get("scope").asInt();
        System.out.println(level+","+scope);
        if(level>scope){
            throw new ForbiddenException(10005);
        }
        return true;
    }
 /*   private void setToThreadLocal(Map<String,Claim> map) {
        Long uid = map.get("uid").asLong();
        Integer scope = map.get("scope").asInt();
        Optional<User> user = this.userService.getUserById(uid);
        LocalUser.set(user, scope);
    }*/
}
