package com.linebead.myPointCut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author liushengtao
 * @description 描述
 * @date 2024年10月13日11:11
 */
@Component
@Aspect
public class MyPointCut {
    /*切面表达式提取*/
    @Pointcut("execution(* com.linebead.service.*.*(..))")
    public void pc(){

    }
}
