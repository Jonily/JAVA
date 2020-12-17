package com.my.dao;

import com.my.pojo.User;
import com.my.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class UserMapperTest {
    @Test
    public void test(){
//第一步，获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            //方式一 执行sql getMapper
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userDao.getUserList();

      /*  //方式二
        List<User> userList = sqlSession.selectList("com.my.dao.UserDao.getUserList");*/
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();

    }
    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       int ret =  mapper.addUser(new User(4,"都菁怡","12345"));
       if(ret>0){
           System.out.println("ok");
       }
       //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int ret = mapper.updateUser(new User(1,"hh","12316"));
        if(ret > 0){
            System.out.println("ok");
        }
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }





}
