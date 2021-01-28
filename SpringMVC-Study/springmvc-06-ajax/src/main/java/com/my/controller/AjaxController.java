package com.my.controller;

import com.my.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/a1")
    public void ajax1(String name , HttpServletResponse response) throws IOException {
        System.out.println("a1.param"+name);
        if ("admin".equals(name)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }
    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList = new ArrayList<User>();
        userList.add(new User("奥特曼",123,"nan"));
        userList.add(new User("奥特曼2",12,"女"));
        userList.add(new User("奥特曼3",1,"nan"));
        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name,String pwd) {
       String msg = "";
        if(name != null){
            if("admin".equals(name)){
                msg = "ok";
            }else {
                msg="用户名有误";
            }

        }
        if(pwd != null){
            if("123456".equals(pwd)){
                msg = "ok";
            }else {
                msg="密码有误";
            }

        }

        return msg;
    }
}