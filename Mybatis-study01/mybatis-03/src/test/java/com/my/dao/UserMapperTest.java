package com.my.dao;

import com.my.pojo.User;
import com.my.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class UserMapperTest {


    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(3);
        System.out.println(user);

        sqlSession.close();

    }

//    select * from mybatis.user where id = #{id}
//    select id,name,pwd from mybatis.user where id=#{id}






}
