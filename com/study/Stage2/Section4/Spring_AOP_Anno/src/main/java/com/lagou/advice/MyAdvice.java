package com.lagou.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */

@Component
@Aspect  //升级为切面类 配置切入点和通知的关系

public class MyAdvice {

    @Pointcut("execution(* com.lagou.service.impl.AccountServiceImpl.*(..))")
    public void myPoint(){}

    @Before("MyAdvice.myPoint()")
    public void before(){
        System.out.println("前置通知执行了");
    }

    @AfterReturning("MyAdvice.myPoint()")
    public void afterReturning(){
        System.out.println("后置通知执行了");
    }


}
