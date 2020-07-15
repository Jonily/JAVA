package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    //1、新增用户（注册）
    //把一个User 对象插入到数据库中
    void add(User user){
        //1、获取到数据库连接
        Connection connection = DBUtil.getConnection();
        //2、拼装SQL语句
        String sql = "insert into user values (null, ?, ?)";
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());

            //3、执行SQL语句
            int ret = statement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //2、按照名字查找用户（登录）
    public User selectByName(String name){
        //1、和数据库建立连接
        Connection connection = DBUtil.getConnection();
        //2、拼装SQL
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            //3、执行SQL
            resultSet = statement.executeQuery();

            //4、遍历结果

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
