package Dao.Student;

import JdbcConnection.JdbcConnection;
import Model.Students;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoMysql_Implement implements StudentDao {
    private List<Students> studentList;
    @Override
    public List<Students> getAll() {
        try {
            String query = "SELECT *FROM student";
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            studentList = new ArrayList<>();

            while (resultSet.next())
            {
                String name = resultSet.getString("studentName");
                int id = resultSet.getInt("studentId");
                Students s = new Students(id,name);
                studentList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    @Override
    public boolean deleteStudent(int studentId) {
        try {
            Connection connection = JdbcConnection.getConnection();
/*
            Statement statement = connection.createStatement();
            String query;
            query = "DELETE FROM registration WHERE studentId = " + studentId;
            statement.executeUpdate(query);
            query = "DELETE FROM grades WHERE studentId = " + studentId;
            statement.executeUpdate(query);
            query = "DELETE FROM student WHERE studentId = " + studentId;
            int count = statement.executeUpdate(query);
*/
            String query = "DELETE FROM registration WHERE studentId = ?";
            PreparedStatement statement1 = connection.prepareStatement(query);
            statement1.setInt(1,studentId);
            statement1.executeUpdate();

            query = "DELETE FROM grades WHERE studentId = ?";
            PreparedStatement statement2 =  connection.prepareStatement(query);
            statement2.setInt(1,studentId);
            statement2.executeUpdate();

            query = "DELETE FROM student WHERE studentId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,studentId);
            int count = statement.executeUpdate();

            if(count > 0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Students getStudent(int studentId) {

        Students student = null;

        try {
            Connection connection = JdbcConnection.getConnection();
            String query = "SELECT *FROM student WHERE studentId = ?" ;
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,studentId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                String name = resultSet.getString("studentName");
                int id = resultSet.getInt("studentId");
                student = new Students(id,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean updateStudent(Students students) {
        try {
            Connection connection = JdbcConnection.getConnection();
/*
            Statement statement = connection.createStatement();
            String query = "UPDATE student SET studentId='"+ students.getStudentId() +"'," +
                    "studentName='"+ students.getStudentName() +"'WHERE studentId = " + students.getStudentId();
            int count = statement.executeUpdate(query);
*/
            String query = "UPDATE student SET studentId = ? ,studentName = ? WHERE studentId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,students.getStudentId());
            statement.setString(2,students.getStudentName());
            statement.setInt(3,students.getStudentId());
            int count = statement.executeUpdate();
            if(count > 0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void insertStudent(Students students) {
        try {
            Connection connection = JdbcConnection.getConnection();

            String query = "INSERT INTO student(studentId, studentName) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,students.getStudentId());
            statement.setString(2,students.getStudentName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
