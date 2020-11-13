package com.lagou.dao.impl;

import com.lagou.dao.IUserDao;

public class UserDaoImpl implements IUserDao {


    @Override
    public void save() {
        System.out.println("Dao层被调用 保存成功");
    }
}
