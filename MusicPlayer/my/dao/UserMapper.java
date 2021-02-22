package com.my.dao;

import com.my.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //查找用户

    User findUser(@Param("userName") String userName,@Param("passWord") String passWord);
    //添加用户
    int addUser (User user);
    // //通过名字查看用户
    User findUserByName(@Param("name") String name);
    //删除用户
    int deleteUserById(@Param("id") int id);

}

