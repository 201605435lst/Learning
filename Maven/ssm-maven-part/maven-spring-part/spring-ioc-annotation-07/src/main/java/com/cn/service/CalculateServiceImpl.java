package com.cn.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CalculateServiceImpl implements CalculateService{

    @Override
    public int add(int i, int j) {

        int result = i + j;

        return result;
    }

    @Override
    public int sub(int i, int j) {

        int result = i - j;

        return result;
    }

    @Override
    public int mul(int i, int j) {

        int result = i * j;

        return result;
    }

    @Override
    public int div(int i, int j) {

        int result = i / j;

        return result;
    }
}
