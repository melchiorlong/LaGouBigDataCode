package com.lagou.homework.web.Servlet;

import com.lagou.homework.DAO.UserVerifying;
import com.lagou.homework.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author tianlong
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserVerifying verifying = new UserVerifying();
        try {
            User user = verifying.userVerifying(username, password);

            if (user != null){
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.getWriter().write("登录成功！");
            } else {
                resp.getWriter().write("错误！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
