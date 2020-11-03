package com.lagou.Filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterA implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterA 拦截了请求。。。");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterA 响应增强");
    }

    @Override
    public void destroy() {

    }
}
