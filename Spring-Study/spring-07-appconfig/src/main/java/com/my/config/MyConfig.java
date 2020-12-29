package com.my.config;


import com.my.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.my.pojo")
public class MyConfig {
    //注册一个Bean，就相当于我们之前写的一个bean标签
    //这个方法的名字相当于bean标签中的的id属性
    //这个方法的返回值相当于bean标签中的class属性
    @Bean
    public User getUser(){
        return new User();//返回要注入bean的对象
    }

}
