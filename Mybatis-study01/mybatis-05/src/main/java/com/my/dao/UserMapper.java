package com.my.dao;

import com.my.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface UserMapper {


    @Select("select id,name,pwd as password from user")
    List<User> getUsers();

    @Select("select id,name,pwd as password from user where id = #{id}")
    User getUserById(@Param("id") int id);//多个参数的话，所有的参数前面加@Param()注解参数


    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password}) ")
    int addUser(User user);//引用对象不需要@Param

    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where name = #{n1}")
    int deleteUserByName(@Param("n1") String name);
}
