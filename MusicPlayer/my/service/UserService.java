package com.my.service;

import com.my.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;


public interface UserService {
    //查找用户

    User findUser(String userName,String passWord);
    //添加用户
    int addUser (User user);
    // //通过名字查看用户
    boolean findUserByName(String userName);
    //删除用户
    int deleteUserById(int id);


}
