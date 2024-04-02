package com.myPonitCut;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年04月02日15:16
 */
@Aspect
@Component
public class PontCutInfoLog {

    @Before("com.myPonitCut.MyPointCut.pc()")
    public void before() {
        System.out.println("before");
    }

    @After("com.myPonitCut.MyPointCut.pc()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning(pointcut = "com.myPonitCut.MyPointCut.pc()")
    public void afterReturn() {
        System.out.println("afterReturn");
    }
}
