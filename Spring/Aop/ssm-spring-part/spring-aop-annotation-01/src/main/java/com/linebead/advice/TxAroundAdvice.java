package com.linebead.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author liushengtao
 * @description 环绕通知
 * @date 2024年10月14日15:49
 */

@Aspect
@Component
public class TxAroundAdvice  {

    @Around("com.linebead.myPointCut.MyPointCut.pc()")
    public Object transaction(ProceedingJoinPoint joinPoint) {
        final Object[] args = joinPoint.getArgs();

        Object result=null;

        try {

            /*开启事务*/
            System.out.println("开启事务");
            result = joinPoint.proceed(args);
            System.out.println("结束事务");
        } catch (Throwable throwable) {
            /*事务回滚*/
            System.out.println("事务回滚");
            throw new RuntimeException(throwable);
        }
        return result;


    }
}
