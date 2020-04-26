package com.example.demo.config;

import com.example.demo.compant.MyHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;

@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInterceptor())
                .addPathPatterns("/test")
                .excludePathPatterns("/", "/greeting");
        super.addInterceptors(registry);
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
                registry.addViewController("/index.html").setViewName("success");
//                registry.addViewController("/main.html").setViewName("dashbord");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");
        super.addResourceHandlers(registry);
    }
}
