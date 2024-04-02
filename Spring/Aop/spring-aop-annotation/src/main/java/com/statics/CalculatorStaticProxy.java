package com.statics;

import com.service.Calculator;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年03月29日15:42
 */
public class CalculatorStaticProxy implements Calculator {

    private Calculator target;

  public   CalculatorStaticProxy(Calculator calculator) {
        this.target = calculator;
    }

    @Override
    public int add(int i, int j) {

        // 附加功能由代理类中的代理方法来实现
        System.out.println("参数是：" + i + "," + j);

        // 通过目标对象来实现核心业务逻辑
        int addResult = target.add(i, j);

        System.out.println("方法内部 result = " + addResult);

        return addResult;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
