package Main;

import Model.Course;
import Model.Student;
import ServiceAccessObject.StudentService;
import SessionFactoryProvider.SessionFactorySingleton;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class main {

    public main() {

/*        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction =  session.beginTransaction();*/

        // Insert into data base
//        session.save(new Student(1,"Shamim"));
//        session.save(new Student(2,"Kamrul"));
//        session.save(new Student(3,"Sourav"));
//
//        session.save(new Course("Cse2015","Java",3.0));
//        session.save(new Course("Cse2016","Java Lab",1.0));
//        session.save(new Course("Cse4047","Advance Java",3.0));
//        session.save(new Course("Cse4048","Advance Java Lab",1.0));

        // Insert value into new column

//        Student student = session.get(Student.class,2);
//        student.setStudentEmail("kamrul@yahoo.com");


        // Many To Many Relation
//        Student student = session.get(Student.class,2);
//        Course course = session.get(Course.class,"Cse2015");
//        Course course1 = session.get(Course.class,"Cse2016");
//        Course course2 = session.get(Course.class,"Cse4047");
//        student.getCourseSet().add(course);
//        student.getCourseSet().add(course1);
//        student.getCourseSet().add(course2);

        // All Retrieve
//        Query query = session.createQuery("FROM Student"); // Must be HQL And make sure that table name is Entity class name
//        List<Student> studentList = query.getResultList();
//
//        for (Student student: studentList) {
//            System.out.println(student);
//        }

        // Single Retrieve
//        Student student = session.get(Student.class,2);
//
//        System.out.println(student);
//        for (Course course: student.getCourseSet()) {
//            System.out.println(course);
//        }

        /*Query query1 = session.createQuery("FROM Student WHERE studentId = 2");
        List<Student> studentList = query1.getResultList();
        for (Student student: studentList) {
            System.out.println(student);
        }

        transaction.commit();


        session.close();
        sessionFactory.close();*/

        /* End of Procedural */

        /* Start of OOP */
        StudentService studentService = new StudentService();

        // Insert Single Student
//        studentService.addStudent(new Student(7,"Mamun"));

        // Insert multiple Student
        /*List<Student> studentList =  new ArrayList<>();
        studentList.add(new Student(5,"Rajon"));
        studentList.add(new Student(6,"Rony"));
        studentList.add(new Student(7,"Mamun"));
        studentList.add(new Student(8,"Romim"));
        studentService.addAllStudent(studentList);*/

        // Get List of Student
        /*List<Student> studentList = new ArrayList<>();
        studentList = studentService.getAllStudent();
        studentList.forEach(System.out :: println);*/

        // Delete Student
//        studentService.deleteStudent(7);

        // Update Student
//        int studentId = 7;
//        String studentName = "Md Mamun";
//        String studentEmail = "mamun123@hotmai.com";
        int studentId = 8;
        String studentName = "Romim";
        String studentEmail = "romim@gmail.com";
        studentService.updateStudent(studentId,studentName,studentEmail);


        // Get Single Student
        System.out.println(studentService.getStudent(8));

        SessionFactorySingleton.getSessionFactory().close();
    }

    public static void main(String[] args) {
        new main();
    }
}
