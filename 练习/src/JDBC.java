import java.sql.*;

public class JDBC {
    public void  JDBC(){

        try {
            Class.forName("com.mysql");
            String conStr = "jdbc:mysql://localhost:root;DatabaseName=school";
            String user = "root";
            String password = "123456";
            Connection connection = DriverManager.getConnection(conStr,user,password);

            Statement st = connection.createStatement();

            String strsql = "select teNum from teacher";
            ResultSet resultSet = st.executeQuery(strsql);
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+",");
                System.out.println();

            }
            resultSet.close();
            st.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
