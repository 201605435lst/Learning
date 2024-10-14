package com.lbd.service;

import com.lbd.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(JavaConfig.class)
class StudentServiceImplTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void test() {
        studentService.changeInfo("测试修改1",88,1);

    }


}