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



}
