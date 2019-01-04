package Main;

import ConnectionDB.CourseDao;
import ConnectionDB.CourseDaoCSVImplmplmnt;
import ConnectionDB.CourseDaoMysqlImplmnt;
import Model.Course;

import java.util.List;

/**
 * @author Md Shamim
 *
 * @version 1.0-SNAPSHOT
 */
public class main {
    public static void main(String[] args) {

        System.out.println("We are in Main");

        List<Course> courseList;
        // For Mysql Database
//        CourseDao courseDao = new CourseDaoMysqlImplmnt();

        // For Dummy File CSV
        CourseDao courseDao = new CourseDaoCSVImplmplmnt();

        // Get all Data
        courseList = courseDao.getALL();
//        courseList.forEach(System.out :: println);

        // Delete Data By ID
//        courseDao.deleteData(9);

        // Find Data By ID
        System.out.println(courseDao.getCourse(8));

        courseDao.updateData(new Course(8,"Cse4012","Networking Lab",1));

        System.out.println(courseDao.getCourse(8));


    }
}
