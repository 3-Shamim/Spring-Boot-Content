package Main;


import Dao.Course.CourseDao;
import Dao.Course.CourseDaoMysql_Implement;
import Dao.Grade.GradeDao;
import Dao.Grade.GradeDaoMysql_Implement;
import Dao.Registration.RegistrationDao;
import Dao.Registration.RegistrationDaoMysql_Implement;
import Dao.Student.StudentDao;
import Dao.Student.StudentDaoMysql_Implement;
import Model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private Map<Integer, Students> studentMap;
    private Map<String, Course> courseMap;
    private Map<String, Faculty> facultyMap;  // Set doesn't work for it has no get method
    private Map<String, Grade> gradeMap;

    public Main() {

        studentMap = new HashMap<>();
        courseMap =  new HashMap<>();
        facultyMap =  new HashMap<>();
        gradeMap = new HashMap<>();

        StudentDao studentDao = new StudentDaoMysql_Implement();

        CourseDao courseDao = new CourseDaoMysql_Implement();

        RegistrationDao registrationDao = new RegistrationDaoMysql_Implement();

        GradeDao gradeDao = new GradeDaoMysql_Implement();

        // For Students

        List<Students> studentList = studentDao.getAll();
        for (Students students: studentList) {
            studentMap.put(students.getStudentId(),students);
        }

//        studentMap.forEach((key, value) -> {
//            System.out.println(key + " -> " + value);
//        });

//        studentList.forEach(System.out::println);

//        studentDao.deleteStudent(10004);

//        studentDao.updateStudent(new Students(10008,"Update Ok"));

//        Students students =  new Students(15000,"Shamim");
//        studentDao.insertStudent(students);
//
//        Students student = studentDao.getStudent(15000);
//
//        System.out.println(student);

        // For Courses

        List<Course> courseList = courseDao.getAll();
        for (Course course: courseList) {
            courseMap.put(course.getCourseCode(), course);
        }
//        courseList.forEach(System.out :: println);

        //For Registrations

        List<Registration> registrationList =  registrationDao.getAll();

        for (Registration registration: registrationList) {
            facultyMap.putIfAbsent(registration.getFacultyInitials(), new Faculty(registration.getFacultyInitials()));
        }

//        registrationList.forEach(System.out :: println);

        // For GradeRecord
        for (Grade grade: Grade.values()) {

            gradeMap.put(grade.getLetterGrade(),grade);
        }

        List<GradeRecord> gradeRecordList = gradeDao.getAll();

        for (GradeRecord gradeRecord : gradeRecordList) {
            int studentId = gradeRecord.getStudentId();
            String courseCode = gradeRecord.getCourseCode();
            String facultyInitial = gradeRecord.getFacultyInitials();

            Students student = studentMap.get(studentId);
            Course course = courseMap.get(courseCode);
            Faculty faculty = facultyMap.get(facultyInitial);
            Grade grade = gradeMap.get(gradeRecord.getGrade());
            int semesterId = gradeRecord.getSemesterId();

            /*System.out.println(gradeRecord);
            System.out.println(course);
            System.out.println(student);
            System.out.println(faculty);
            System.out.println(grade.getLetterGrade() + " -> " + grade.getNumericGrade());
            System.out.println();*/

            GradeEntry gradeEntry =  new GradeEntry(course,faculty,studentId,grade,semesterId);
            student.getGradeEntryList().add(gradeEntry);
        }

//        gradeRecordList.forEach(System.out :: println);

//        studentList.forEach(System.out :: println);

//        Students students = studentList.get(studentList.size() - 8);
//        System.out.println(students.getStudentId());
//
//        for(int i = 40; i < 46; i++)
//        {
//            System.out.println(i + " : " + students.getTermGpa(i));
//        }


        Students students = studentMap.get(13941);
        students.studentFullResultDetails().forEach((key, value) -> {
            System.out.println(key.getCourseCode() + " -> " + key.getCourseCredit() + " -> " + value + " -> " +  value.getNumericGrade());
        });
        System.out.println(students.getCgpa());


    }

    public static void main(String[] args) {
        new Main();
    }
}
