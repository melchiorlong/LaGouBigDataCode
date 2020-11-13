package com.lagou.homework.web.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 */
//@WebFilter("/*")
public class EncodingFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//        if ("post".equalsIgnoreCase(httpServletRequest.getMethod())) {
//            httpServletRequest.setCharacterEncoding("UTF-8");
//        }
        httpServletRequest.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html;charset=utf-8");
//
//
//        HttpSession session = httpServletRequest.getSession();
//        User user = (User) session.getAttribute("user");
//        if(user != null){
            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            httpServletResponse.getWriter().println("asdfasd");
//        }


    }

    @Override
    public void destroy() {

    }
}
