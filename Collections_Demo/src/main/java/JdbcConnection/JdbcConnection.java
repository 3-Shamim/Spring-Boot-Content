package JdbcConnection;

import java.sql.*;

public class JdbcConnection {

    private static JdbcConnection instant = new JdbcConnection();
    private static Connection connection;

    private JdbcConnection() {
//        System.out.println("From Constructor");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            final String url = "jdbc:mysql://localhost:3306/predictdb";
            final String user = "root";
            final String pass = "";
            connection = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
//        System.out.println("From method");
        return connection;
    }

}
