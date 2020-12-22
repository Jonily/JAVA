package com.my.dao;


import com.my.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //查询指定用户
    User queryUserById(@Param("id") int id);

    //修改用户
    int updateUser(User user);



}
