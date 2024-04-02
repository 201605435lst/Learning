package com.useAop;

import com.service.Calculator;
import com.service.CalculatorImpl;
import com.dyn.ProxyFactory;
import com.statics.CalculatorStaticProxy;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年03月29日16:22
 */
public class UseAop {
    public static void main(String[] args) {

        Calculator calculator = new CalculatorImpl();
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(calculator);
        int ss = calculatorStaticProxy.add(1, 2);
        System.out.println("ss = " + ss);


        ProxyFactory proxyFactory = new ProxyFactory(calculator);
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1, 2);

    }
}
