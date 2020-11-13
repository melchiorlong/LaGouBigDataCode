package com.lagou.Dao.impl;

import com.lagou.Dao.IUserDao;

public class UserDaoImpl implements IUserDao {
    public void save() {
        System.out.println("调用了DAO");
    }
}
