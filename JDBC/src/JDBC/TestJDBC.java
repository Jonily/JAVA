package JDBC;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        //1、创建DataSource对象(DataSource 对象生命周期跟随整个程序)
        DataSource dataSource = new MysqlDataSource();
        //加下来需要针对dataSource进行一些配置，以便后面能够顺利访问数据库服务器
        //配置URL、user、password，需要进行向下转型
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/TestJdbc?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setURL("root");
        ((MysqlDataSource) dataSource).setPassword("123456");


        //2、和数据库建立连接，建立连接好之后可以进行后续数据传输
        //建立连接意义是为了验证当前的网络连接是否正常
        //如果不正常会抛出SQLException异常
        //connection 对象生命周期应该是较短的，每个请求创建一个新的connection
        Connection connection = dataSource.getConnection();

        //3、拼装一个sql语句，用到PrepareStatement 对象，对应到一个SQL语句
        //先插入数据为例
        //当前示例中插入写死，可以在程序运行时获取，动态拼接
        int ud =1;
        String name = "曹操";
        int classId = 10;
        String sql =




    }
}
