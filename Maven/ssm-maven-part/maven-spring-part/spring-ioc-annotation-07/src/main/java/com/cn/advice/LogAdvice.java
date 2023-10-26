package com.cn.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAdvice {

    @Before("")
    public void start(){

    }

    @After("")
    public void after(){

    }

    @AfterThrowing()
    public void error(){

    }
}
