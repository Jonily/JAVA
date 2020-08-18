package DAO;

import model.DBUtil;
import model.User;
import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//实现三个功能
//1、插入用户 注册的时候使用
//2、按姓名查找 登陆时使用
//3、按照用户id查找 展示信息的时候使用
public class UserDao {
    public void add(User user) throws OrderSystemException {
        //1、先获取数据库连接DataSource
        //2、拼装sql语句 PrepareStatement
        //3、执行sql语句executeQuery、executrUpdate
        //4、关闭连接
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into user values (null,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setInt(3,user.getIsAdmin());

           int ret =  preparedStatement.executeUpdate();

           if(ret!=1){
               throw new OrderSystemException("插入用户失败！");
           }
            System.out.println("插入成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("插入用户失败！");
        }finally {
            DBUtil.close(connection,preparedStatement,null);
        }
    }

    public User selectByName(String name) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from user where name = ? ";
        connection  = DBUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));

                return  user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按姓名查找用户失败！");
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return null;
    }

    public User selectById(int userId) throws OrderSystemException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql ="select * from user where userId = ? ";
        connection  = DBUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setIsAdmin(resultSet.getInt("isAdmin"));

                return  user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new OrderSystemException("按id查找用户失败！");
        }finally {
            DBUtil.close(connection,preparedStatement,resultSet);
        }
        return null;
    }

   /* public static void main(String[] args) throws OrderSystemException {
        UserDao userDao = new UserDao();

        User user = new User();
     *//*   user.setName("hhh");
        user.setPassword("123");
        user.setIsAdmin(0);
        userDao.add(user);*//*
        user = userDao.selectByName("hhh");
        //user = userDao.selectById(1);
        System.out.println(user);

    }*/


    
}
