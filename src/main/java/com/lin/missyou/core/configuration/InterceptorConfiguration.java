package com.lin.missyou.core.configuration;

import com.lin.missyou.core.interceptors.PermissionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The type Interceptor configuration.
 *
 * @ClassName: com.lin.missyou.core.configuration
 * @Author: Mrguo
 * @Description: TODO
 * @Date: 2021 /6/17
 * @Version: 1.0
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    /**
     * Get permission interceptor handler interceptor.
     *
     * @return the handler interceptor
     */
    @Bean
    public HandlerInterceptor getPermissionInterceptor(){
        return  new PermissionInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getPermissionInterceptor());
    }
}
