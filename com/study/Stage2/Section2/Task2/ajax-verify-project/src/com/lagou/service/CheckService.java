package com.lagou.service;

import com.lagou.dao.checkDao;

import java.sql.SQLException;

/**
 * @author Administrator
 *
 *
 */
public class CheckService {

    // 检查用户是否存在的check方法
    public boolean check (String name) throws SQLException {
        return new checkDao().daoCheck(name);
    }

}
