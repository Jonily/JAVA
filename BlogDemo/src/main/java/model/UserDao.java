package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    // 1. 新增用户(注册)
    //    把一个 User 对象插入到数据库中.
    public void add(User user) {
        // 1. 获取到数据库连接.
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL 语句
        String sql = "insert into user values (null, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            // 3. 执行 SQL 语句
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("插入新用户失败!");
                return;
            }
            System.out.println("插入新用户成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4. 释放数据库的连接.
            DBUtil.close(connection, statement, null);
        }
    }

    // 2. 按照名字查找用户(登陆)
    public User selectByName(String name) {
        // 1. 和数据库建立连接.
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            // 3. 执行 SQL
            resultSet = statement.executeQuery();
            // 4. 遍历结果集. 预期 name 在数据库中不能重复.
            //    此处查找最多只能查出一条记录来.
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    // 根据用户 id 找到用户信息
    public User selectById(int userId) {
        // 1. 和数据库建立连接.
        Connection connection = DBUtil.getConnection();
        // 2. 拼装 SQL
        String sql = "select * from user where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            // 3. 执行 SQL
            resultSet = statement.executeQuery();
            // 4. 遍历结果集. 预期 name 在数据库中不能重复.
            //    此处查找最多只能查出一条记录来.
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        // 1. 先测试 add 方法
//        User user = new User();
//        user.setName("tz");
//        user.setPassword("1234");
//        userDao.add(user);
        // 2. 测试 selectByName
//        User user = userDao.selectByName("tz");
//        System.out.println(user);
    }

}
