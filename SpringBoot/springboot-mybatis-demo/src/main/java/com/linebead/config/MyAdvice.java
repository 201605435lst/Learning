package com.linebead.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author liushengtao
 * @description 在每一个方法执行之前输出一句话
 * @date 2024年12月07日15:58
 */
@Aspect
@Component
public class MyAdvice {


    @Before("execution(* com..service.*.*(..))")
    public void before(JoinPoint joinPoint) {

        final String className = joinPoint.getTarget().getClass().getSimpleName();
        final String methodName = joinPoint.getSignature().getName();

        System.out.println("className = " + className);
        System.out.println("methodName = " + methodName);

        System.out.println("LogAdvice.before");
        System.out.println("joinPoint = " + joinPoint);
    }


}
