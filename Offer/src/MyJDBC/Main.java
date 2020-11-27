package MyJDBC;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.driver");

            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/musicserver?characterEncoding=utf-8&useSSL=true");

            statement = connection.createStatement();

            String url = "select id from mmp";
            resultSet = statement.executeQuery(url);

            while (resultSet.next()){

                int id = resultSet.getInt("id");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

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
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
