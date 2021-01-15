package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HelloController")
public class HelloController {

    //真实访问地址:项目名/HelloController/hello
    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据，在模型中添加属性msg值，可以在jsp页面中取出并渲染
        model.addAttribute("msg","Hello,SpringMVCAnnotation！");
        //WEB-INF/jsp/hello.jsp
        return "hello";//会被视图解析器处理
    }
}
