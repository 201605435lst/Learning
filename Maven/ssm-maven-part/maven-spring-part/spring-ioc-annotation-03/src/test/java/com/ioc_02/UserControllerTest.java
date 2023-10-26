package com.ioc_02;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_03.xml");
        UserController userController = applicationContext.getBean(UserController.class);
        userController.show();
    }
}