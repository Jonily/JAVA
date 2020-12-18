package com.my.dao;

import com.my.pojo.User;
import com.my.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;
import java.util.Map;


import java.util.HashMap;


public class UserMapperTest {

    static Logger logger =  Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        logger.info("进入连接");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(3);
        System.out.println(user);

        sqlSession.close();

    }
    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");

    }

     @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);

        List<User> list = mapper.getUserByLimit(map);
        for (User user : list) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1,2);
        //通过java层面实现分页
        List<User> userList = sqlSession.selectList("com.my.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();

    }


}
