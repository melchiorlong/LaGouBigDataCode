package com.lagou.Session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Administrator
 */
public class SetSession extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 将需要共享的数据存到session中
        HttpSession session = req.getSession();
        session.setAttribute("name", "哈哈哈");
        System.out.println("共享数据已经存入session");

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
