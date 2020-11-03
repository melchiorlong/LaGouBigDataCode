package com.lagou.homework.web.Servlet;

import com.lagou.homework.DAO.AddFacade;
import com.lagou.homework.domain.Student;
import com.lagou.homework.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int gender = Integer.parseInt(req.getParameter("gender"));
        Date birthdate = java.sql.Date.valueOf(req.getParameter("birthdate"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("password = " + password);

        Student student = new Student();
        student.setFName(name);
        student.setFNumber(username);
        student.setGender(gender);
        student.setBirthDate(birthdate);

        User user = new User();
        user.setFUserName(username);
        user.setFPassword(password);

        System.out.println("user = " + user);
        System.out.println("student = " + student);

        try {
            AddFacade.add(student);
            AddFacade.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
