package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/success")
    public String success() {

        return "main";
    }


    @RequestMapping("/gologin")
    public String goLogin() {

        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model) {
        //把用户信息存储在Session中
        session.setAttribute("userLogin",username);
        model.addAttribute("username",username);
        return "main";
    }
    //退出登陆
    @RequestMapping("logout")
    public String logout(HttpSession session) throws Exception {
        // session 过期
        session.removeAttribute("userLogin");
        return "login";
    }
}
