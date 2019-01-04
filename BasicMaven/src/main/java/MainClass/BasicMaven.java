package MainClass;

import ModelClass.Course_Details;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BasicMaven {

    private List<Course_Details> courseDetailsList;

    public BasicMaven() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            final String url = "jdbc:mysql://localhost:3306/studentdemo";
            final String user = "root";
            final String pass = "";
            String query = "select *from course_details";
//            String query = "select max(course_credit) from course_details";
//            String query = "select max(length(course_title)), course_title from course_details";
            String query1 = "select course_title from course_details " +
                    "where length(course_title) = (select max(length(course_title)) from course_details)";

            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            courseDetailsList = new ArrayList<>();
            while (resultSet.next()) {
                String courseCode = resultSet.getString("course_code");
                String courseTitle = resultSet.getString("course_title");
                int courseCredit = resultSet.getInt("course_credit");

                Course_Details course_details = new Course_Details(courseCode, courseTitle, courseCredit);

                courseDetailsList.add(course_details);
//                System.out.println(courseCode + " : " + courseTitle + " : " + courseCredit);
            }

            ResultSet resultSet1 = statement.executeQuery(query1);

            while (resultSet1.next()) {
//                System.out.println(course_details);
//                System.out.println("Max Name of String Value = " + resultSet.getInt(1));
                System.out.println("Max Length of Course Title = " + resultSet1.getString("course_title"));
            }

           /* for (Course_Details c: courseDetailsList) {
                System.out.println(c);
            }*/

            courseDetailsList.forEach(System.out::println);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String arg[]) {
        new BasicMaven();
    }
}
