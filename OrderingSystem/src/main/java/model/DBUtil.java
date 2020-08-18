package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DBUtil 本质上是一个管理了单例的 DataSource 的类
public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/order_system?characterEncoding=utf8&useSSL=true";
//    private static final String URL = "jdbc:mysql://47.98.116.42:3306/java16_order_system?characterEncoding=utf8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static volatile DataSource dataSource = null;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    // 数据库连接失败是很常见的问题. 如果失败, 后续的操作肯定也是失败的.
    // 如果发现 Connect 为 null, 就说明数据库连接失败, 就需要查看错误信息(Tomcat 的日志)
    // 常见的问题就是, url, username, password 等信息写错了, 或者数据库没有启动.
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("数据库连接失败, 请检查数据库是否启动正确, url 是否正确");
        return null;
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
