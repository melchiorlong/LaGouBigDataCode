package com.lagou.servlet_demo;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Administrator
 */
public class QuickServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /*
    * 对外提供服务的方法
    * tomcat会调用servlet中的service方法 执行具体业务逻辑
    * ServletRequest：请求对象，借助该对象来获取请求参数
    * ServletResponse：响应对象，借助该对象来向浏览器响应一些数据
    * */

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet入门成功！");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
