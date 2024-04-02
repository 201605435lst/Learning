package com.service;


import org.springframework.stereotype.Service;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年03月29日15:15
 */
@Service
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int i, int j) {

        int result = i + j;
        System.out.println("result = " + result);
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
