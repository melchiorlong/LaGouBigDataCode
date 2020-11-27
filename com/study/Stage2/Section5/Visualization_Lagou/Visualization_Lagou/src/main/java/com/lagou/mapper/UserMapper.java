package com.lagou.mapper;

import com.lagou.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface UserMapper {

    /**
     * 根据用户名查找用户是否存在
     * @param username
     * @return
     */

    int check(String username);


    /**
     * 用户登录
     * @param username
     * @param md5Password
     * @return
     */
    User selectLogin(@Param("username") String username, @Param("password") String md5Password);


    /**
     * 查询所有
     */
    List<User> userList();

    int checkEmail(String str);

    int insert(User user);

    int deleteByPK(int id);

    User selectByPK(int userId);

    int update(User user);
}
