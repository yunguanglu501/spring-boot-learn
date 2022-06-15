package com.example.learn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/15 10:11
 */
@Configuration
public class GlobalWebMvcConfig implements WebMvcConfigurer {


    @Resource
    private HandlerInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可按照顺序定义多个
        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
        // 支持定义多个PathPattern和excludePathPatterns
        //registry.addInterceptor(xxxInterceptor).addPathPatterns("/xxx","/**").excludePathPatterns("/yyy","/zzz");
    }
}
