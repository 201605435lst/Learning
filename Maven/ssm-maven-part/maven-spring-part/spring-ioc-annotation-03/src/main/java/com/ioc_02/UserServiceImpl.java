package com.ioc_02;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public void show() {
        System.out.println("这是UserServiceImpl的方法");
    }
}
