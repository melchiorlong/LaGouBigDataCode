package com.lagou.test;

import com.lagou.domain.Account;
import com.lagou.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Administrator
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class AccountServiceTest {


    @Autowired
    private AccountService accountService;


    // 测试保存方法

    @Test
    public void testSave (){
        Account account = new Account();
        account.setName("lucy");
        account.setMoney(100000d);
        accountService.save(account);
    }

    // 测试查询所有

    @Test
    public void  testFindAll(){
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println("account = " + account);
        }
    }

    // 测试findById

    @Test
    public void testFindById(){
        Account account = accountService.findById(1);
        System.out.println("account = " + account);
    }

    // 测试更新

    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(5);
        account.setName("lucy");
        account.setMoney(1000000d);
        accountService.update(account);
    }

    // 测试删除

    @Test
    public void testDelete(){
        accountService.delete(5);
    }



}
