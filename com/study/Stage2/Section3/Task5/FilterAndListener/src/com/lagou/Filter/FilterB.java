package com.lagou.Filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterB implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterB 拦截了请求。。。");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterB 响应增强");

    }

    @Override
    public void destroy() {

    }
}
