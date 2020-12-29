package com.my.pojo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


// 等价于在配置文件中的<bean id="user" class="com.my.pojo.User"/>
@Component
public class User {
    @Value("lalalala")
    public String name ;

}
