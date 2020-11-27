package com.lagou.service.impl;

import com.lagou.mapper.AccountMapper;
import com.lagou.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional  // 事务控制
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int tranfer(String inName, String outName, Double money) {
        try {
            // 调用转入
            accountMapper.transferIn(inName, money);
            // 调用转出
            accountMapper.transferOut(outName, money);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
}
