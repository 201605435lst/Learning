package com.linebead.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * @author liushengtao
 * @description
 * @date 2024年10月13日9:56
 */
@Aspect
@Component
public class MyAdvice {

    /*方法执行之前*/

    /*切面表达式
     * 1.访问修饰符 public/private
     * 2.方法返回参数 string/void
     * 如果不考虑返回值和访问修饰符，用*表示，如果两个有一个不考虑，另一个也不能考虑。
     * 3.包的位置
     *    具体包，com.linebead.service
     *    单层包，com.linebead.service.*
     *    多层包，com..impl
     * 4.类名 *
     * 5.方法名 *
     * 6.参数名（..）..表示多个或者有和没有
     * */
/*    TODO:实战
    1、查询某包某类下，访问修饰符是公有，返回值是int的全部方法
    public int xx.xx.jj.*(..)
            2、查询某包下类中第一个参数的String的方法
    * xx.xx.jj.*(String..)
            3、查询全部包下，无参数的方法
    * *..*.*()
            4、查询com包下，以int参数类型结尾的方法
   * com..*.*(..int)
            5、查询指定包下，service开头类的私有方法返回值int的无参数方法
    privite int xx.xx.service*.*()
*/







    @Before("com.linebead.myPointCut.MyPointCut.pc()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before");
        /*1、获取类的信息*/
        String methodName = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println("methodName = " + methodName);
        /*2、获取方法名称*/
        String name = joinPoint.getSignature().getName();
        System.out.println("name = " + name);
        //3、获取参数名称*/
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg = " + arg);
        }
        //4、获取访问修饰符*/
        final int modifiers = joinPoint.getSignature().getModifiers();
        String modifier = Modifier.toString(modifiers);

        System.out.println("modifier = " + modifier);


    }

    /*方法执行中*/

    @AfterReturning(value = "com.linebead.myPointCut.MyPointCut.pc()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("around=" + result);
    }

    /*方法执行之后*/

    @After("com.linebead.myPointCut.MyPointCut.pc()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after");
    }




    /*方法执行出错*/

    @AfterThrowing(value = "com.linebead.myPointCut.MyPointCut.pc()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("error=" + e);
    }

}
