package com.lagou.test;


import com.lagou.proxy.CglibProxyFactory;
import com.lagou.proxy.JDKProxyFactory;
import com.lagou.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Administrator
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:ApplicationContext.xml"})
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JDKProxyFactory jdkProxyFactory;

    @Autowired
    private CglibProxyFactory cglibProxyFactory;


    @Test
    public void testTransfer() throws Exception {
        accountService.transfer("tom", "jerry", 100.00);
    }


    // JDK动态代理

    @Test
    public void testTransferJDKProxy() throws Exception {
        // 当前返回的时候AccountService的代理对象Proxy
        AccountService accountServiceJDKProxy = jdkProxyFactory.createAccountServiceJDKProxy();

        // 代理对象proxy调用接口中的任意方法时，都会执行底层的invoke方法
        accountServiceJDKProxy.transfer("tom", "jerry", 100.00);
    }


    // Cglib动态代理

    @Test
    public void testTransferCgLibProxy() throws Exception {
        // 当前返回的时候AccountService的代理对象Proxy
        AccountService accountServiceCglibProxy = cglibProxyFactory.createAccountServiceCglibProxy();

        // 代理对象proxy调用接口中的任意方法时，都会执行底层的invoke方法
        accountServiceCglibProxy.transfer("tom", "jerry", 100.00);


    }


}
