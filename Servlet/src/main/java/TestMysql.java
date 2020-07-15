import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMysql {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/java16?characterEncoding=utf-8&useSSL=true";
        String username = "root";
        String password = "123456";
        //借助dataSource来管理数据库连接
        //1、创建DataSource实例，并设置数据库的相关参数
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);
        //2、和数据库建立连接
        Connection connection = dataSource.getConnection();
        //3、返回数据库，需要先拼装一个sql语句
        String sql = "select * from student";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
        //4、执行sql
        ResultSet resultSet = statement.executeQuery();
        //5、遍历结果集
        //每次调用next方法，就可以获取一条记录
        //进一步调用get。根据列名，获取到对应列的数据
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getDouble("sore"));
            System.out.println(resultSet.getString("email"));

        }
        //6、关闭连接，释放资源
        //关闭顺序和创建顺序刚好相反
        resultSet.close();
        statement.close();
        connection.close();

    }
}
