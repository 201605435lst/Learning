package com.test;

import com.cn.config.JavaConfig;
import com.cn.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {



    @Autowired
    private CalculateService calculateService;

    @Test
    public void test(){
        int add = calculateService.add(3, 5);
        System.out.println("add = " + add);
    }
}
