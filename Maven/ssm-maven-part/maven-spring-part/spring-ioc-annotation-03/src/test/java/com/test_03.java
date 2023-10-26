package com;

import com.ioc_03.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_03 {

    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_033.xml");
        JavaBean javaBean = applicationContext.getBean(JavaBean.class);
        System.out.println(javaBean);
    }
}
