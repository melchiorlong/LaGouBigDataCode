package com.lagou.service.impl;

import com.lagou.dao.AccountDao;
import com.lagou.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * 手动开启事务 调用事务管理器类中的开启事务方法
 * 调用转账方法
 * 手动提交事务
 * 手动回滚事务
 * 手动释放资源
 */

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public void transfer(String outUser, String inUser, Double money) throws Exception {
// 调用转账方法
        accountDao.out(outUser, money);
//            int i =1/0;
        accountDao.in(inUser, money);


    }

    @Override
    public void update() {
        System.out.println("update方法");
    }

    @Override
    public void save() {
        System.out.println("sava方法");

    }

    @Override
    public void delete() {
        System.out.println("delete方法");

    }
}
