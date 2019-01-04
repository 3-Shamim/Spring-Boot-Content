package ConnectionDB;

import Model.Course;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoMysqlImplmnt implements CourseDao {

    private List<Course> courseList;

    @Override
    public List<Course> getALL() {
        try {
            Connection connection = jdbcConnection.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("Select *from course_details");

            courseList = new ArrayList<>();

            while(resultSet.next())
            {
                int id = resultSet.getInt("id");
                String code = resultSet.getString("course_code");
                String title = resultSet.getString("course_title");
                int credit = resultSet.getInt("course_credit");

                Course course = new Course(id,code,title,credit);
                courseList.add(course);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courseList;
    }

    @Override
    public Course getCourse(int p_id) {
        Course course = null;

        try {
            Connection connection = jdbcConnection.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select *from course_details WHERE id = " + p_id);

            while(resultSet.next())
            {
                int id = resultSet.getInt("id");
                String code = resultSet.getString("course_code");
                String title = resultSet.getString("course_title");
                int credit = resultSet.getInt("course_credit");

                course = new Course(id,code,title,credit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return course;
    }

    @Override
    public boolean deleteData(int id) {

        try {
            Connection connection = jdbcConnection.getConnection();

            Statement statement = connection.createStatement();

            // If Relation between table then it should no tbe work
            // you should delete ar single column value from all of this table and

            int x = statement.executeUpdate("delete from course_details WHERE id = " + id);

            if(x > 0)
            {
                return  true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateData(Course course) {

        try {
            Connection connection = jdbcConnection.getConnection();
            Statement statement = connection.createStatement();

            int x = statement.executeUpdate("UPDATE `course_details` SET `course_code`='"+ course.getCourseCode() +"',`course_credit`="+ course.getCourseCredit() +",`course_title`='"+ course.getCourseTitle() +"' WHERE `id` = " + course.getId());

            if(x>0)
            {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


}
