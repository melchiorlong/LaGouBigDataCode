package com.lagou.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {

        // 向ServletContext域中存入一个count变量 初始值为0
        this.getServletContext().setAttribute("count", 0);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置响应文字编码
        resp.setContentType("text/html;charset=utf-8");

        // 向页面响应信息
        resp.getWriter().write("<h1>田龙的博客</h1>");

        // ServletContext域中取值
        Integer count = (Integer) this.getServletContext().getAttribute("count");
        // 将count加1
        count += 1;
        // 显示
        resp.getWriter().write("<dev>你是第" + count + "个访问的人</dev>");
        // 将count存入ServletCont域中
        this.getServletContext().setAttribute("count", count);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
