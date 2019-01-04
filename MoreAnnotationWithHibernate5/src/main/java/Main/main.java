package Main;

import Model.Course;
import Model.Sex;
import Model.StudentDetails;
import ServiceAccessObject.CourseService;
import ServiceAccessObject.StudentService;
import SessionFactoryProvider.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class main {

    public main() {
        StudentService studentService =  new StudentService();
        CourseService courseService = new CourseService();

//        courseService.addCourse(new Course("Cse2015","Java",3));
//        courseService.addCourse(new Course("Cse2016","Java Lab",1));
//        courseService.addCourse(new Course("Cse4047","Advance Java",3));
//        courseService.addCourse(new Course("Cse4048","Advance Java Lab",1));
//        courseService.addCourse(new Course("Cse4029","Image Processing",3));
//        courseService.addCourse(new Course("Cse1011","C Programming",3));
//        courseService.addCourse(new Course("Cse1012","C Programming Lab",1));

//        StudentDetails studentDetails =  new StudentDetails(1,null,null, Sex.MALE,null);

//        for(int i = 0; i < 100; i++)
//        {
//            studentService.addStudentDetails(new StudentDetails(i,
//                    null,
//                    null,
//                    Math.random() < .5 ? Sex.MALE : Sex.FEMALE,
//                    null));
//        }

//        List<StudentDetails> studentDetailsList = studentService.getAllStudentDetails();
//
//        List<StudentDetails> studentDetails = studentDetailsList
//                .parallelStream()
//                .filter(studentDetails1 -> studentDetails1.getSex() == Sex.MALE)
//                .collect(Collectors.toList());
//        System.out.println(studentDetails.size());
//        studentDetails.forEach(System.out :: println);

        // Need to fix this part
//        StudentDetails studentDetails1 = studentService.getStudentDetails(1);

//        studentDetails1.setEmail("shamim@gmail.com");
//        System.out.println(studentDetails1);

//        Course course = courseService.getCourse("Cse2015");
//        Course course1 = courseService.getCourse("Cse2016");
//        Course course2 = courseService.getCourse("Cse4047");
//        Course course3 = courseService.getCourse("Cse4048");
//        Course course4 = courseService.getCourse("Cse4029");
//        System.out.println(course + "\n" + course1 + "\n" + course2 + "\n" + course3 + "\n" + course4);
//
//
//        studentDetails1.getCourseSet().add(course);
//        studentDetails1.getCourseSet().add(course1);
//        studentDetails1.getCourseSet().add(course2);
//        studentDetails1.getCourseSet().add(course3);
//        studentDetails1.getCourseSet().add(course4);
//        System.out.println(studentDetails1);

//        studentService.addStudentDetails(studentDetails1);

        studentService.deleteStudentDetails(2);

        StudentDetails studentDetails1 = studentService.getStudentDetails(2);
        System.out.println(studentDetails1);


        SessionFactorySingleton.getSessionFactory().close();
    }

    public static void main(String[] args) {
        new main();
    }
}
