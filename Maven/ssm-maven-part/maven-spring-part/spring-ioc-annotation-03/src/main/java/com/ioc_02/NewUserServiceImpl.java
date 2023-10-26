package com.ioc_02;

import org.springframework.stereotype.Service;

@Service

public class NewUserServiceImpl implements UserService{
    @Override
    public void show() {
        System.out.println("new=====================这是UserServiceImpl的方法");
    }
}
