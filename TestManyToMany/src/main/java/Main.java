import Model.Course;
import Model.Student;
import ServiceAccessObject.SessionFactoryProvider;
import ServiceAccessObject.courseService;
import ServiceAccessObject.studentService;

public class Main {

    public Main() {
        courseService courseservice = new courseService();
        studentService studentservice = new studentService();

//        Student student = new Student(2, "Kamrul");
//        studentservice.addStudent(student);

//        Course course = new Course("Cse2016","Java Lab");
//        courseservice.addCourse(course);


        Student student = studentservice.getStudent(1);
        System.out.println(student);

        Course course = courseservice.getCourse("Cse101");
        Course course1 = courseservice.getCourse("Cse2015");
        Course course2 = courseservice.getCourse("Cse2016");
        System.out.println(course + "  " + course1 + "  " + course2);

        student.getCourseSet().add(course);
        student.getCourseSet().add(course1);
        student.getCourseSet().add(course2);

        System.out.println(student);

        studentservice.addStudent(student);




        SessionFactoryProvider.getSessionFactory().close();
    }

    public static void main(String[] args) {
        new Main();
    }
}
