package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.common.Const;
import com.lagou.common.ResponseCode;
import com.lagou.common.ServerResponse;
import com.lagou.model.User;
import com.lagou.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 */

@Controller
@RequestMapping("/user")
@Transactional
public class UserController {


    @Autowired
    private IUserService iUserService;

    // 用户登录方法

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession httpSession) {
        // 调用service登录方法 会返回ServerResponse<User>
        ServerResponse<User> response = iUserService.login(username, password);

        // 判断是否登录成功，如果成功 把当前User放到session中
        if (response.getStatus() == ResponseCode.SUCCESS.getCode()) {
            httpSession.setAttribute(Const.CURRENT_USER, response.getData());
        }

        // 返回ServerResponse
        return response;
    }


    /**
     * 分页查找
     */
    @RequestMapping(value = "/list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        ServerResponse<PageInfo> users = iUserService.getUsers(pageNum, pageSize);
        return users;
    }


    /**
     * 添加用户
     */

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> add(User user) {
        return iUserService.add(user);
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/deleteUser.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delete(int id) {
        return iUserService.delete(id);
    }

    /**
     * 用户注销方法
     */
    @RequestMapping(value = "/logout.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        try {
            session.removeAttribute(Const.CURRENT_USER);
            return ServerResponse.createBySuccessMsg("注销成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMsg("注销失败");
        }
    }

    /**
     * 根据id查找用户
     */
    @RequestMapping("/findById.do")
    @ResponseBody
    public ServerResponse<User> findById(int id){
        ServerResponse<User> user = iUserService.findById(id);
        return user;
    }

    /**
     * 用户修改
     */
    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> update(User user){
        return iUserService.update(user);
    }

}
