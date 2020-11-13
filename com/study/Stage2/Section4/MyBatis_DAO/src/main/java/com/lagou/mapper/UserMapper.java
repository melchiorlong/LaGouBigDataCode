package com.lagou.mapper;

import com.lagou.domain.User;

import java.util.List;

/**
 * @author Administrator
 */
public interface UserMapper {

    // 根据id进行用户查询

    public User findUserById(int id);

    // 查询所有

    public List<User> findAllResultMap();

    // 模糊查询

    public List<User> findByUserName(String username);

    // 插入用户

    public void savaUser(User user);

    // 动态sql

    public List<User> findByIdAndUsernameIf(User user);

    // 动态更新

    public void updateIf(User user);

    // 动态foreach

    public List<User> findByList(List<Integer> ids);
}
