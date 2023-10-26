package com.cn;

import com.cn.controller.ProxyFactory;
import com.cn.service.CalculateService;
import com.cn.service.CalculateServiceImpl;

public class UseAop {


    public static void main(String[] args) {
        CalculateService calculateService=new CalculateServiceImpl();

        ProxyFactory proxyFactory=new ProxyFactory(calculateService);
        CalculateService proxy = (CalculateService) proxyFactory.getProxy();

        int add = proxy.add(4, 5);

    }

}
