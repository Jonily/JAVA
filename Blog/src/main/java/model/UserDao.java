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
        //常见异常原因
        //1、url写错（数据库的IP，端口号、数据库名、url格式错误）
        //2、数据库服务器没有启动
        //3、连其他主机的数据库，会被mysql安全策略阻拦
        Connection connection = DBUtil.getConnection();//和数据库建立连接

        //2、拼装SQL语句
        String sql = "insert into user values (null, ?, ?)";
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());

            //3、执行SQL语句
            int ret = statement.executeUpdate();
            if(ret != 1){
                System.out.println("插入新用户失败!");
                return;
            }
            System.out.println("插入新用户成功！");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //4、释放数据库连接
            DBUtil.close(connection,statement,null);
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

            //4、遍历结果(预期name在数据库中不能重复，只有一个)
            if(resultSet.next()){
                User user = new User();
                user.setUseId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //5、释放连接
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

}
