package com.lagou.mapper;

import com.lagou.domain.User;

import java.util.List;

/**
 * @author Administrator
 */
public interface UserMapper {

    // 根据id进行用户查询

    public User findUserById(int id);

    public List<User> findAllResultMap();


}
