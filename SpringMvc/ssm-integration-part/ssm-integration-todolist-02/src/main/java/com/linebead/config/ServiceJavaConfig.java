package com.linebead.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author liushengtao
 * @description 主要配置service,注解aop和声明事务相关配置
 * @date 2024年12月05日16:18
 */

/**
 * 1. 声明@Configuration注解,代表配置类
 * 2. 声明@EnableTransactionManagement注解,开启事务注解支持
 * 3. 声明@EnableAspectJAutoProxy注解,开启aspect aop注解支持
 * 4. 声明@ComponentScan("com.atguigu.service")注解,进行业务组件扫描
 * 5. 声明transactionManager(DataSource dataSource)方法,指定具体的事务管理器
 */
@EnableTransactionManagement
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.linebead.service")
public class ServiceJavaConfig {


    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}
