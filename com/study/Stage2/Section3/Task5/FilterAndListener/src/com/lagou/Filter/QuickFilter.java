package com.lagou.Filter;

import javax.servlet.*;
import java.io.IOException;

public class QuickFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化方法
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//        servletRequest 请求对象
//        servletResponse 响应对象
//        filterChain 过滤器链 (是否放行)

        System.out.println("这个是QuickFilter拦截了请求....");

        // 放行状态
        filterChain.doFilter(servletRequest, servletResponse);
        // 再进行拦截
        System.out.println("这个是QuickFilter拦截了响应....");



    }

    @Override
    public void destroy() {
        // 销毁方法
    }
}
