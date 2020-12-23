package com.my.dao;

import com.my.pojo.User;
import java.util.Map;

import java.util.List;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //添加用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    //Map使用
    int  addUser2(Map<String,Object> map);

    //模糊查询
    List<User> getUserLike(String value);



}
