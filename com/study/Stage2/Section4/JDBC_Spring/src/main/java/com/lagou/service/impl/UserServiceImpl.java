package com.lagou.service.impl;

import com.lagou.dao.IUserDao;
import com.lagou.dao.impl.UserDaoImpl;
import com.lagou.service.IUserService;
import com.lagou.utils.BeanFactory;

public class UserServiceImpl implements IUserService {



    @Override
    public void save() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        // 调用DAO层 传统方法
//        IUserDao userDao = new UserDaoImpl();
//        userDao.save();


        // 利用反射机制 但是存在硬编码问题
//        IUserDao iUserDao = (IUserDao) Class.forName("com.lagou.dao.impl.UserDaoImpl").newInstance();
//        iUserDao.save();

        // 使用BeanFactory获取实例对象
        IUserDao userDao = (IUserDao) BeanFactory.getBean("userDao");
        userDao.save();

    }
}
