package com.lagou.mapper;

import com.lagou.domain.User;

import java.util.List;

public interface UserMapper {

    // 查询所有用户，与此同时查询出该用户具有的订单

    public List<User> findAllWithOrders();

    // 查询所有用户同时查询出该用户的所有角色

    public List<User> findAllUserWithRole();

    // 根据id查询用户

    public User findUserById(int id);

    // 查询所有用户，与此同时查询出该用户具有的订单

    public List<User> findAllWithOrders2();

    // 查询所有用户同时查询出该用户的所有角色

    public List<User> findAllUserWithRole2();

}
