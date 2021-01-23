package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {

    @RequestMapping("/add")
    public String test(int a, int b, Model model){
        int ret = a+b;
        model.addAttribute("msg","结果为"+ret);
        return "hhh";
    }

    //@RequestMapping(value = "/add2/{a}/{b}",method = RequestMethod.DELETE)
    @GetMapping("/add2/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model){
        int ret = a+b;
        model.addAttribute("msg","结果为"+ret);
        return "hhh";
    }
}
