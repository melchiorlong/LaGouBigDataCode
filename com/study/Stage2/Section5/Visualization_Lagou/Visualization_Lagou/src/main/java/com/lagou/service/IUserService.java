package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.common.ServerResponse;
import com.lagou.model.User;

/**
 * @author Administrator
 */
public interface IUserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public ServerResponse<User> login(String username, String password);
    /**
     * 分页查找
     */
    ServerResponse<PageInfo> getUsers(int pageNum, int pageSize);
    /**
     * 用户新增
     */
    ServerResponse<String> add(User user);
    /**
     * 用户删除
     */
    ServerResponse<String> delete(int id);
    /**
     * 用户修改
     */
    ServerResponse<String> update(User user);
    /**
     * 根据id查找用户
     */
    ServerResponse<User> findById(int id);


}
