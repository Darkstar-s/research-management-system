package com.zc.controller.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LogInterceptor logInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).addPathPatterns("/user/index.html");
        registry.addInterceptor(logInterceptor).addPathPatterns("/admin/index.html");
        registry.addInterceptor(logInterceptor).addPathPatterns("/bk/index.html");
        registry.addInterceptor(logInterceptor).addPathPatterns("/sysadmin/index.html");






                /*.addPathPatterns("/**")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/plugins/**")
                .excludePathPatterns("/favicon.ico");*/

    }
}
