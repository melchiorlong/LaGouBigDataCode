package com.lagou.adivce;

/**
 * @author Administrator
 */
public class MyAdvice {

    public void before(){
        System.out.println("前置通知执行了");
    }


    public void afterReturning(){
        System.out.println("后置通知执行了");
    }

}
