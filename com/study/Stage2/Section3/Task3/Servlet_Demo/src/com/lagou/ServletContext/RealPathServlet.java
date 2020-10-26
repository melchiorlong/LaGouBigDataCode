package com.lagou.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RealPathServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = req.getServletContext();
        String realPath = servletContext.getRealPath("/img/pipi.jpg");
        System.out.println("realPath = " + realPath);
//        I:\LaGou_BigData_Study\src\com\study\Stage2\Section3\Task3\Servlet_Demo\web\img
//        I:\LaGou_BigData_Study\out\artifacts\Servlet_Demo_war_exploded\img\pipi.jpg

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
