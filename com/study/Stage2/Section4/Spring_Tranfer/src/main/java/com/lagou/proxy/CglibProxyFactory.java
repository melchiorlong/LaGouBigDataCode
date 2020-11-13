package com.lagou.proxy;

import com.lagou.service.AccountService;
import com.lagou.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * 采用cglib动态代理类对目标类进行方法的动态增强
 */

@Component
public class CglibProxyFactory {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager transactionManager;

    public AccountService createAccountServiceCglibProxy() {

        AccountService accountServiceProxy = null;
        // 编写cglib对应的API生成对象对象进行返回
//        参数一：目标对象的字节码对象
//        参数二：动作类，实现增强功能

        accountServiceProxy = (AccountService) Enhancer.create(accountService.getClass(), new MethodInterceptor() {

            // Object   : 代表生成的代理对象
            // Method   :调用目标方法的引用
            // Object[] :方法入参
            // MethodProxy: 代理方法

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                try {
                    transactionManager.beginTransaction();
                    result = method.invoke(accountService, objects);
                    transactionManager.commit();
                } catch (Exception e) {
                    transactionManager.rollback();
                    e.printStackTrace();
                } finally {
                    transactionManager.release();
                }
                return result;
            }
        });
        return accountServiceProxy;
    }

}
