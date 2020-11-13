package com.lagou.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author Administrator
 *
 * 1 开启事务
 * 2 提交事务
 * 3 回滚事务
 * 4 释放资源
 *
 */
@Component
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Around("execution(* com.lagou.service.impl.AccountServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Exception {

        Object proceed = null;
        try {
            // 开启手动事务
            connectionUtils.getThreadConnection().setAutoCommit(false);
            // 切入点方法执行
            proceed = pjp.proceed();
            // 手工提交事务
            connectionUtils.getThreadConnection().commit();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            connectionUtils.getThreadConnection().rollback();
        } finally {
            // 手动事务改回自动提交事务
            connectionUtils.getThreadConnection().setAutoCommit(true);

            // 将连接还给连接池
            connectionUtils.getThreadConnection().close();

            // 解除线程绑定
            connectionUtils.removeThreadConnection();
        }

        return null;
    }

    public void beginTransaction(){

        // 获取Connection对象
        try {
            // 开启一个手动事务
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release(){
        try {
            // 手动事务改回自动提交事务
            connectionUtils.getThreadConnection().setAutoCommit(true);

            // 将连接还给连接池
            connectionUtils.getThreadConnection().close();

            // 解除线程绑定
            connectionUtils.removeThreadConnection();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }

}
