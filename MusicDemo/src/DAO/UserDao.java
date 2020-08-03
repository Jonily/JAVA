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

        String sql ="insert into user values (null ,?,?)";
        try{
            connection = DBUtils.getConnect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,preparedStatement,null);
        }
    }

    //通过名字查看用户
    public boolean findUserByName(String s){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "select * from user where username = ? ";

        try{
            connection = DBUtils.getConnect();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,s);

           resultSet =  preparedStatement.executeQuery();
           if(resultSet.next()){
               return true;
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,preparedStatement,resultSet);
        }
        return false;
    }

    //注销
    public  int deleteUser(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "delete from user where id=?";
        try {
            connection = DBUtils.getConnect();
            statement= connection.prepareStatement(sql);//对sql语句的预编译
            statement.setInt(1,id);
            int ret = statement.executeUpdate();

            if(ret == 1){
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,statement,null);
        }
        return 0;
    }

    public static void main(String[] args) {
       /* UserDao userDao = new UserDao();
        userDao.deleteUser(1);*/
      /* User user= new User();
        user.setUsername("bit");

        System.out.println(findUserByName(user.getUsername()));*/
    }
}
