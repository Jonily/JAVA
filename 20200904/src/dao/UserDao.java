package dao;

import exception.userException;
import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    //新增用户
    public void addUser (User user) throws userException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "insert into user values (null,?,?)";

        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"user_name");
            preparedStatement.setString(2,"user_password");

            int ret = preparedStatement.executeUpdate();
            if(ret != 1){
                throw  new userException("插入用户失败");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw  new userException("插入用户失败");

        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }

    //根据名字删除用户
    public void deleteUserByName (String name) throws userException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "delete from user where user_name = ?";

        connection = DBUtil.getConnect();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);


            int ret = preparedStatement.executeUpdate();
            if(ret != 1){
                throw  new userException("删除用户失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw  new userException("删除用户失败");

        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
    }
}
class Test{
    public static void main(String[] args) throws userException {
        UserDao userDao  = new UserDao();
        User user = new User();
        user.setUser_name("yaya");
        user.setUser_password("123");
        userDao.addUser(user);
    }
}
