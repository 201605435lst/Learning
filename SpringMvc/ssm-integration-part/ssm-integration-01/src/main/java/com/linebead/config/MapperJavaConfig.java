package com.linebead.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月05日16:46
 */
@Configuration

public class MapperJavaConfig {

    /**
     * 配置SqlSessionFactoryBean,指定连接池对象和外部配置文件即可
     * @param dataSource 需要注入连接池对象
     * @return 工厂Bean
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        //实例化SqlSessionFactory工厂
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        //设置连接池
        sqlSessionFactoryBean.setDataSource(dataSource);

        //设置配置文件
        //包裹外部配置文件地址对象
        Resource resource = new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);

        return sqlSessionFactoryBean;
    }

    /**
     * 配置Mapper实例扫描工厂,配置 <mapper <package 对应接口和mapperxml文件所在的包
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //设置mapper接口和xml文件所在的共同包
        mapperScannerConfigurer.setBasePackage("com.linebead.mapper");
        return mapperScannerConfigurer;
    }






}
