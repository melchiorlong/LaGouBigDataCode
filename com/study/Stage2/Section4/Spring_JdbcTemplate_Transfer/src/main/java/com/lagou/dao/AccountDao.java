package com.lagou.dao;

import com.lagou.domain.Account;

public interface AccountDao {

    public void out(Integer outUserID, Double money);
    public void in(Integer inUserID, Double money);
}
