package com.my.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //登录页面放行
        if(request.getRequestURI().contains("gologin")){
            return true;
        }
        if(request.getRequestURI().contains("login")){
            return true;
        }
        //放行判断
        if(session.getAttribute("userLogin")!= null){
            return true;
        }
        //未登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
