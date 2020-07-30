package DAO;

import DBUtil.DBUtils;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    //登录
    public User login(User loginUser){
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "select * from  user where username=? and password =?";
            connection = DBUtils.getConnect();
            statement= connection.prepareStatement(sql);//对sql语句的预编译
            statement.setString(1,loginUser.getUsername());
            statement.setString(2,loginUser.getPassword());

            //执行sql语句
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
                user.setGender(resultSet.getString("gender"));
                user.setEmail(resultSet.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,resultSet);
        }
        return user;
    }
    //注册
    public void register(User user){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql ="insert into user values (null ,?,?,?,?,?)";
        try{
            connection = DBUtils.getConnect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getGender());
            preparedStatement.setInt(4,user.getAge());
            preparedStatement.setString(5,user.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,preparedStatement,null);
        }
    }

    public static void main(String[] args) {
      /*  User user= new User();
        user.setUsername("bit");
        user.setPassword("123");
        User loginUser  = login(user);
        System.out.println(loginUser);*/
    }
}
