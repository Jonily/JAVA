package model;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static sun.plugin.javascript.navig.JSType.URL;

//用于管理数据库连接
//1、建立连接 断开连接
//JDBC使用DataSource连接，DBUtil是对DataSource再稍微包装一层
//DataSource每个应用程序只应该有一个实例（单例），DBUtil本质上就是实现一个单例模式管理唯一一个
//DataSource实例   单例模式 饿汉 懒汉
//使用懒汉
public class DBUtil {
    private static DataSource dataSource = null;
    private static final String url = "jdbc:mysql://127.0.0.1:3306/myBlog?characterEncoding=utf-8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
  /*  懒汉实现的单例模式有一个重要的问题:
    线程不安全
    首次使用getDataSource,如果是多线程调用，就可能会产生线程不安全的问题.
*/
    public static DataSource getDataSource(){
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if(dataSource == null){
                    dataSource = new MysqlDataSource();
                    //给dataSource设置属性
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setURL(USERNAME);
                    ((MysqlDataSource)dataSource).setURL(PASSWORD);
                }
            }
        }
        return  dataSource;
    }

    //通过这个方法获取连接
    public static Connection getConnection(){
        try{
            return getDataSource().getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //通过这个方法断开连接
    public static void close(Connection connection, PreparedStatement statement,
                             ResultSet resultSet){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
