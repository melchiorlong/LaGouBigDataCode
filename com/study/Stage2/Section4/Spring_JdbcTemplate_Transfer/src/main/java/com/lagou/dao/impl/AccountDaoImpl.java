package com.lagou.dao.impl;

import com.lagou.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void out(Integer outUserId, Double money) {
        String sql = "update account set money = money - ? where id = ?";
        jdbcTemplate.update(sql, money, outUserId);
    }


    @Override
    public void in(Integer inUserId, Double money) {
        String sql = "update account set money = money + ? where id = ?";
        jdbcTemplate.update(sql, money, inUserId);
    }
}
