package com.lagou.service;

import com.lagou.domain.Account;

/**
 * @author Administrator
 */



public interface AccountService {



    public void transfer(Integer outUserId, Integer inUserId, Double money);


}
