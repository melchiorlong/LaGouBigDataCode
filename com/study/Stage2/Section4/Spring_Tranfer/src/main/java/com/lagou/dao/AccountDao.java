package com.lagou.dao;

import java.sql.SQLException;

/**
 * @author Administrator
 */
public interface AccountDao {

    // 转出操作

    public void out(String outUser, double money) throws SQLException;


    // 转入操作

    public void in(String inUser, double money) throws SQLException;

}
