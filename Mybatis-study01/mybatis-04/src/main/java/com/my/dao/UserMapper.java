package com.my.dao;

import com.my.pojo.User;

import java.util.List;
import java.util.Map;


public interface UserMapper {

    //根据id查询用户
    User getUserById(int id);

    //实现分页
    List<User> getUserByLimit(Map<String,Integer> map);



    //RowBound分页
    List<User> getUserByRowBounds();

}
