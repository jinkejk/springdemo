package com.example.demo.config;

import com.example.demo.compant.MyHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport{

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //静态资源已经被springboot做好映射
        registry.addInterceptor(new MyHandlerInterceptor())
                .addPathPatterns("/greeting")
                .excludePathPatterns("/", "/test");
        super.addInterceptors(registry);
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/main.html").setViewName("dashbord");
    }

}
