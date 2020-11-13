package com.lagou.dao.impl;

import com.lagou.dao.AccountDao;
import com.lagou.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @author Administrator
 */

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public void out(String outUser, double money) {
        // 转出操作


        String sql = "update account set money = money - ? where name = ?";
        Object[] param = {money, outUser};
        try {
            queryRunner.update(connectionUtils.getThreadConnection(), sql, param);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void in(String inUser, double money) {
        // 转入操作

        String sql = "update account set money = money + ? where name = ?";
        Object[] param = {money, inUser};
        try {
            queryRunner.update(connectionUtils.getThreadConnection(), sql, param);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
