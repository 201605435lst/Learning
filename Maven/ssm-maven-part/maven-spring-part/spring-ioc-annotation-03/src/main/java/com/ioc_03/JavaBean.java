package com.ioc_03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaBean {
    private String name="这是测试名称";

    @Value("12")
    private Integer age;

    @Value("${jdbc.userName:默认名称}")
    private String userName;

    @Value("${jdbc.password:默认密码}")
    private String password;

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
