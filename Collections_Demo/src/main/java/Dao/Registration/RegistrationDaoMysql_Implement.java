package Dao.Registration;

import JdbcConnection.JdbcConnection;
import Model.Registration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDaoMysql_Implement implements RegistrationDao {

    private List<Registration> list;

    @Override
    public List<Registration> getAll() {
        list = new ArrayList<>();

        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *FROM registration");

            while(resultSet.next())
            {
                String studentId = resultSet.getString("studentId");
                String courseCode = resultSet.getString("courseCode");
                String facultyInitials = resultSet.getString("facultyInitials");
                int semesterId = resultSet.getInt("semesterId");

                list.add(new Registration(studentId, courseCode, facultyInitials, semesterId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
