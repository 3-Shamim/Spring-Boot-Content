package Dao.Grade;

import JdbcConnection.JdbcConnection;
import Model.GradeRecord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoMysql_Implement implements GradeDao {

    private List<GradeRecord> list;

    @Override
    public List<GradeRecord> getAll() {
        list = new ArrayList<>();

        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *FROM grades");

            while(resultSet.next())
            {
                int studentId = Integer.parseInt(resultSet.getString("studentId"));
                String courseCode = resultSet.getString("courseCode");
                String facultyInitials = resultSet.getString("facultyInitials");
                String grade = resultSet.getString("Grade");
                int semesterId = resultSet.getInt("semesterId");

                list.add(new GradeRecord(studentId, courseCode, facultyInitials, grade, semesterId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
