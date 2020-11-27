package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.common.Const;
import com.lagou.common.ResponseCode;
import com.lagou.common.ServerResponse;
import com.lagou.mapper.UserMapper;
import com.lagou.model.User;
import com.lagou.service.IUserService;
import com.lagou.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        // 检查用户名是否存在 (0:用户不存在 1: 存在)
        int resultCount = userMapper.check(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("用户不存在");
        }
        // 使用MD5给密码加密
        String md5Password = MD5Util.MD5EncodeUtf8(password);
        // 调用mapper中的登录方法 如果成功返回User对象，user== null 密码错误
        User user = userMapper.selectLogin(username, md5Password);
        // 判断User对象是否为空，若空则登录失败 密码错误
        if (user == null) {
            return ServerResponse.createByErrorMsg("密码错误");
        }
        // 如果User不是空则登录成功 ，清空密码
        user.setPassword(StringUtils.EMPTY);
        // 封装一个ServerResponse，返回成功信息
        return ServerResponse.createBySuccessMsgData("登录成功", user);
    }

    /**
     * 分页查询用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     */

    @Override
    public ServerResponse<PageInfo> getUsers(int pageNum, int pageSize) {
        // 给PageHelper分页助手设置两个参数 pageNum pageSize
        PageHelper.startPage(pageNum, pageSize);
        // 查询所有信息
        List<User> list = userMapper.userList();
        // 创建pageInfo 把查询到的用户list放到pageInfo中
        PageInfo pageInfo = new PageInfo(list);
        // 返回ServerResponse，添加pageInfo
        return ServerResponse.createBySuccessData(pageInfo);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */

    @Override
    public ServerResponse<String> add(User user) {
        // 校验用户名是否存在
        ServerResponse<String> validResponse = this.checkValid(user.getUsername(), Const.USERNAME);
        if (validResponse.getStatus() != ResponseCode.SUCCESS.getCode()) {
            return validResponse;
        }
        // 校验邮箱是否存在
        validResponse = this.checkValid(user.getEmail(), Const.EMAIL);
        if (validResponse.getStatus() != ResponseCode.SUCCESS.getCode()) {
            return validResponse;
        }
        // 密码加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        // 添加数据到数据库 resultCount=1 插入成功 resultCount=0插入失败
        int resultCount = userMapper.insert(user);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("创建失败");
        }
        return ServerResponse.createBySuccessMsg("创建成功");
    }


    /**
     * 校验用户名是否存在or校验邮箱是否存在
     *
     * @param str  用户名or邮箱
     * @param type 用户名or邮箱
     * @return
     */
    public ServerResponse<String> checkValid(String str, String type) {
        if (StringUtils.isNotBlank(type)) {
            // 校验用户名
            if (Const.USERNAME.equals(type)) {
                // 查询用户名是否存在
                int resultCount = userMapper.check(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMsg("用户名已存在");
                }
            }
            // 校验邮箱
            if (Const.EMAIL.equals(type)) {
                int resultCount = userMapper.checkEmail(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMsg("邮箱已存在");
                }
            }
        }
        return ServerResponse.createBySuccessMsg("用户名及邮箱可以使用");
    }


    /**
     * 删除用户
     *
     * @param id 用户id
     * @return
     */

    @Override
    public ServerResponse<String> delete(int id) {
        // 校验该用户是否存在
        ServerResponse<User> userInformation = this.getInformation(id);
        User user = userInformation.getData();
        if (user == null) {
            return ServerResponse.createByErrorMsg("删除用户不存在");
        }
        // 如该用户存在 则删除该用户，得到返回值
        int resultCount = userMapper.deleteByPK(id);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("删除失败");
        }
        return ServerResponse.createBySuccessMsg("删除成功");
    }

    /**
     * 根据主键id查询user
     *
     * @param userId
     */
    public ServerResponse<User> getInformation(int userId) {
        User user = userMapper.selectByPK(userId);
        if (user != null) {
            return ServerResponse.createBySuccessData(user);
        }
        return ServerResponse.createByErrorMsg("用户不存在");
    }

    /**
     * 用户修改
     */
    @Override
    public ServerResponse<String> update(User user) {
        Integer userId = user.getId();
        User originUser = userMapper.selectByPK(userId);
        String originUserUsername = originUser.getUsername();
        String originUserEmail = originUser.getEmail();
        String newUsername = user.getUsername();
        String newEmail = user.getEmail();

        if (!originUserUsername.equals(newUsername)){
            int resultCount = userMapper.check(newUsername);
            if (resultCount > 0) {
                return ServerResponse.createByErrorMsg("用户名已存在");
            }
        }
        if (!originUserEmail.equals(newEmail)){
            int resultCount = userMapper.checkEmail(newEmail);
            if (resultCount > 0) {
                return ServerResponse.createByErrorMsg("邮箱已存在");
            }
        }
        int resultCount = userMapper.update(user);
        if (resultCount == 0){
            return ServerResponse.createByErrorMsg("更新失败");
        } else {
            return ServerResponse.createBySuccessMsg("更新成功");
        }
    }

    /**
     * 根据id查找用户
     */
    @Override
    public ServerResponse<User> findById(int id) {
        ServerResponse<User> user = this.getInformation(id);
        return user;
    }


}
