package com.linebead.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年10月12日20:57
 */
@Aspect
@Component

public class AdviceLog {

    @Before("execution(* com.linebead.service.*.*(..))")
    public void start() {
        System.out.println("方法开始了");
    }

    @After("execution(* com.linebead.service.*.*(..))")
    public void after() {
        System.out.println("方法结束了");
    }

    @AfterThrowing("execution(* com.linebead.service.*.*(..))")
    public void error() {
        System.out.println("方法出错了");
    }

}
