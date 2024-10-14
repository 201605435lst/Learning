package com.linebead.service;

import org.springframework.stereotype.Component;


/**
 * @author liushengtao
 * @description 描述
 * @date 2024年10月12日19:51
 */

@Component
public class CalculatorImpl implements Calculator {
    public int add(int i, int j) {
        return i + j;
    }

    public int sub(int i, int j) {
        return i - j;
    }

    public int mul(int i, int j) {
        return i * j;
    }

    public int div(int i, int j) {
        return i / j;
    }
}
