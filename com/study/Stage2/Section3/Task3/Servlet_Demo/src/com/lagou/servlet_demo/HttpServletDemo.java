package com.lagou.servlet_demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 */
public class HttpServletDemo extends HttpServlet {

    private static final long serialVersionUID = -1333398342306857646L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("执行了Get方法");
        System.out.println("执行了Get方法");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("执行了Post方法");
        System.out.println("执行了Post方法");
    }
}
