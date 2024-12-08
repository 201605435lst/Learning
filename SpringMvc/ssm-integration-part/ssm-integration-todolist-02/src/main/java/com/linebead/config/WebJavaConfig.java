package com.linebead.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author liushengtao
 * @description 主要配置controller,springmvc相关组件配置&
 * @date 2024年12月05日15:34
 */
@Configuration
@ComponentScan("com.linebead.controller")
@EnableWebMvc
public class WebJavaConfig implements WebMvcConfigurer {


    /*视图解析器*/

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
//快速配置jsp模板语言对应的
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    /*静态资源*/
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /*添加拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");

    }

}
