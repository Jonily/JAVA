package JDBC;


import java.sql.*;

public class JDBC {
    public static void main(String[] args)  {
        ResultSet resultSet = null;
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/musicserver?characterEncoding=utf-8&useSSL=true");


            //创建命令对象
            statement = connection.createStatement();

            //执行sql
            String sql = "select id ,number from emp";
            resultSet = statement.executeQuery(sql);

            //处理结果集
            while (resultSet.next()){
                String id = resultSet.getString("id");
                int num = resultSet.getInt("number");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet!= null){
                    resultSet.close();
                }
                if(statement!= null){
                    statement.close();
                }
                if(connection!= null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
}
