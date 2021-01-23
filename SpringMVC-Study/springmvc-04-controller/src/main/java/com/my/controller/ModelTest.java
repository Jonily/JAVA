package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ModelTest {

    @RequestMapping("/m1/t1")
    public String test(Model model){
        model.addAttribute("msg","MdoelTest1");
        return "redirect:/index.jsp";
    }
}
