package com.my.dao;

import com.my.pojo.User;
import com.my.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {

    @Test
    public void getUsers(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList  = mapper.getUsers();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();

    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(2);
        System.out.println(user);
        sqlSession.close();

    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int ret = mapper.addUser(new User(6,"hhhh","12346"));

        System.out.println(ret);
        sqlSession.close();

    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int ret = mapper.updateUser(new User(4,"hehe","12346"));

        System.out.println(ret);
        sqlSession.close();

    }

    @Test
    public void deleteUserByName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int ret = mapper.deleteUserByName("hehe");

        System.out.println(ret);
        sqlSession.close();

    }
}
