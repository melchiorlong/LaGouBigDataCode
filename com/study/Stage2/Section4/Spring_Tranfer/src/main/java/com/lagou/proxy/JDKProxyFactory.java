package com.lagou.proxy;

import com.lagou.service.AccountService;
import com.lagou.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * JDK 动态代理类
 */

@Component
public class JDKProxyFactory {

    // 采用JDK动态代理类生成目标代理对象

    @Autowired
    private TransactionManager transactionManager;

    @Autowired
    private AccountService accountService;

    public AccountService createAccountServiceJDKProxy() {


//        参数：
//        ClassLoader loader,    ：类加载器 借助被代理对象获取到类加载器
//        Class<?>[] interfaces, ：被代理类所需要的实现的全部接口
//        InvocationHandler h    ：当代理对象调用接口中的任意方法时，都会执行InvocationHandler中的invoke方法
        AccountService accountServiceProxy = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
                    @Override // proxy: 当前的代理对象引用 method: 被调用的目标方法的引用 args:被调用的目标方法所需参数
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 被代理对象的原方法执行
                        Object result = null;
                        try {
                            if ("transfer".equalsIgnoreCase(method.getName())){
                                System.out.println("进行了前置增强");
                                // 手动开启事务 调用事务管理器类中的开启事务方法
                                transactionManager.beginTransaction();
                                result = method.invoke(accountService, args);
                                System.out.println("进行了后置增强");
                                // 手动提交事务
                                transactionManager.commit();
                            } else {
                                result = method.invoke(accountService, args);
                            }
                        } catch (Exception e) {
                            // 手动回滚事务
                            transactionManager.rollback();
                            e.printStackTrace();
                        } finally {
                            // 手动释放资源
                            transactionManager.release();
                        }
                        return result;
                    }
                });
        return accountServiceProxy;
    }
}
