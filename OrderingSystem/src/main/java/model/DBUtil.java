package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DBUtil 本质上是一个管理了单例的DataSource的类
public class DBUtil {
    private static final String URL="jdbc:mysql://127.0.0.1:3306/order_system?characterEncoding=utf-8&useSSL=true";
    //private static final String URL="jdbc:mysql://39.97.189.134:3306/order_system?characterEncoding=utf-8&useSSL=true";


    private static final String USERNAME ="root";

    private static final String PASSWORD ="";

    private static volatile DataSource dataSource = null;
    public static DataSource getDataSource(){
        if(dataSource == null){
            synchronized (DBUtil.class){
                if(dataSource == null){
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);

                }
            }
        }

        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败！");

        }
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
