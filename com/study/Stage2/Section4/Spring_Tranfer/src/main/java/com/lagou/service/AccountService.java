package com.lagou.service;

import java.sql.SQLException;

/**
 * @author Administrator
 */
public interface AccountService {

    public void transfer(String outUser, String inUser, Double money) throws SQLException, Exception;

    public void update();
    public void save();
    public void delete();


}
