package com.lagou.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagou.service.CheckService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */

@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
    private static final long serialVersionUID = -794059591457462884L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            // 1、设置编码
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=utf-8");

            // 2、获取前台参数
            String username = req.getParameter("username");

            // 3、调用service的check方法 得到一个boolean值
            CheckService cs = new CheckService();
            boolean checkResult = cs.check(username);

            // 4、创建一个Map对象 给map中设置内容
            Map<String, Object> map = new HashMap<>();

            if (checkResult){
                map.put("isExist", true);
                map.put("msg", "该用户已经存在");
            } else {
                map.put("isExist", false);
                map.put("msg", "该用户名可以使用");
            }

            // 5、将map转为json
            ObjectMapper om = new ObjectMapper();
            String mapJson = om.writeValueAsString(map);

            // 6、将json数据传给前台
            resp.getWriter().print(mapJson);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
