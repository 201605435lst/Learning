package com.linebead.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author liushengtao
 * @description 配置类
 * @date 2024年10月12日20:14
 */
@Configuration
@ComponentScan("com.linebead")
@EnableAspectJAutoProxy
public class JavaConfig {
}
