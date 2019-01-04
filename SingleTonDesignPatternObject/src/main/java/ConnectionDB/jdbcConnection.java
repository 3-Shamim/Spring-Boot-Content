package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Singleton Class for getting a database connection
 */

public class jdbcConnection {

    private static jdbcConnection instance = new jdbcConnection();

    private static Connection connection;

    private jdbcConnection() {

        System.out.println("We are in the private constructor");

        try{
            Class.forName("com.mysql.jdbc.Driver");
            final String url = "jdbc:mysql://localhost:3306/studentdemo";
            final String user = "root";
            final String pass = "";
            connection = DriverManager.getConnection(url,user,pass);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
