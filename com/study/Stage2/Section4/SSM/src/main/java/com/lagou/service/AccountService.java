package com.lagou.service;

import com.lagou.domain.Account;

import java.util.List;

/**
 * @author Administrator
 */
public interface AccountService {

    public List<Account> findAll();


    void save(Account account);

    public Account findById(Integer id);

    void update(Account account);

    void deleteBatch(Integer[] ids);
}
