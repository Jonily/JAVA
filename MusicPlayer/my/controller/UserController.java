package com.my.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.pojo.Music;
import com.my.pojo.User;
import com.my.service.MusicService;
import com.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    //controller层调用service层
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    //1、查询用户-->
    @RequestMapping("/findUser")
    @ResponseBody
    public void findUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        System.out.println("UserController.findUser");
        User user = userService.findUser(userName,passWord);
        Map<String,Object> return_map = new HashMap<String,Object>();
        System.out.println(user);
        if(user != null){
            System.out.println("登录成功！");
            //登陆成功就把用户信息写入session
            request.getSession().setAttribute("user",user);//绑定数据
            return_map.put("msg",true);
        }else {
            System.out.println("登陆失败！");
            return_map.put("msg",false);
        }

        //将map返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),return_map);
    }


    //注册账号
    @RequestMapping("/addUser")
    @ResponseBody
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        User registerUser = new User();
        registerUser.setName(userName);
        registerUser.setPassword(passWord);
        System.out.println(registerUser);
        Map<String,Object> return_map = new HashMap<String,Object>();
        System.out.println(registerUser.getName());
        if(userService.findUserByName(registerUser.getName())){
            userService.addUser(registerUser);
            System.out.println("注册成功！");
            return_map.put("msg",true);
        }else {
            System.out.println("注册失败！");
            return_map.put("msg",false);
        }

        //将map返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),return_map);
    }

    //注销账号
    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = (User)request.getSession().getAttribute("user");
        int id = user.getId();
        Map<String,Object> return_map = new HashMap<String,Object>();
        System.out.println(id);
        if(userService.deleteUserById(id) == 1){
            return_map.put("msg",true);
        }else {
            return_map.put("msg",false);
        }

        //将map返回给前端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),return_map);
    }


}
