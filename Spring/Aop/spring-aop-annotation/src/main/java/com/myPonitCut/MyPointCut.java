package com.myPonitCut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年04月02日14:50
 */

@Aspect
@Component
public class MyPointCut {

    @Pointcut("execution( * com..*.*(..))")
    public void pc() {

    }
}
