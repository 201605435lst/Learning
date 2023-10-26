package com;


import com.ioc_01.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test_02 {

    @Test
    public void  test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_02.xml");

        JavaBean javaBean = applicationContext.getBean("javaBean",JavaBean.class);
        JavaBean javaBean2 = applicationContext.getBean("javaBean",JavaBean.class);

        System.out.println(javaBean==javaBean2);

        applicationContext.close();
    }
}
