package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
@RequestMapping("/3")
public class HelloController3 {

    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg","HelloController3");
        return "hhh";
    }
}
