package com.lagou.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalExceptionResolver implements HandlerExceptionResolver {


    /*
        Exception e:实际抛出的异常对象
     */

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {

        // 具体的异常处理 产生异常后 跳转到最终的一场界面

        ModelAndView modelAndView = new ModelAndView();
        ModelAndView error = modelAndView.addObject("error", e.getMessage());
        error.setViewName("error");
        return error;
    }
}
