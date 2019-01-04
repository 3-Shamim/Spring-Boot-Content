package Dao.Course;

import JdbcConnection.JdbcConnection;
import Model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoMysql_Implement implements CourseDao {

    private List<Course> list;

    @Override
    public List<Course> getAll() {
        list = new ArrayList<>();

        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *FROM course");

            while(resultSet.next())
            {
                String courseCode = resultSet.getString("courseCode");
                String courseTitle = resultSet.getString("courseTitle");
                int courseCredit = resultSet.getInt("credits");
                list.add(new Course(courseCode, courseTitle, courseCredit));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
