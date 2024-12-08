package com.linebead;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年12月07日19:59
 */

@MapperScan("com.linebead.mapper")
@SpringBootApplication
public class BaseQuickApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseQuickApplication.class, args);
    }


    /*mybatisPlus插件插入到ioc容器*/
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        /*mybatisPlus的插件集合：【插入到这个集合中即可，分页插件，乐观锁插件】*/
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        /*分页插件*/
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        /*乐观锁【版本号插件，】 mubatis-plu会在更新的时候，每次帮我们对比版本号字段和对比版本号*/
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());

        /*防止全表更新或者删除的拦截器*/
        mybatisPlusInterceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());

        return mybatisPlusInterceptor;

    }


}
