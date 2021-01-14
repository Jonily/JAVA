package com.my.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//导入Controller接口
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
        //ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        //封装对象，放在ModelAndView中 Model
        mv.addObject("msg","HelloSpringMvc");
        //封装要跳转的视图，放在ModelAndView中
        mv.setViewName("hello");//:WEB-INF/hello.jsp  hello设置的就是名字
        return mv;
    }
}
