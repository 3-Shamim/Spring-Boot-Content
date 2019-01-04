package com.learningstuff.onetomanyspringbootdemo.Controller;

import com.learningstuff.onetomanyspringbootdemo.Model.Course;
import com.learningstuff.onetomanyspringbootdemo.Model.Student;
import com.learningstuff.onetomanyspringbootdemo.Repository.CourseRepository;
import com.learningstuff.onetomanyspringbootdemo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class Contoller {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    @RequestMapping(value = "")
    @ResponseBody
    public String hello()
    {
        /*addStudent();
        addCourse();*/

        List<Student> students = new ArrayList<>();
        students.addAll((Collection<? extends Student>) studentRepository.findAll());

        Student student = studentRepository.findOne(2);

        Set<Course> courses = new HashSet<>();
//        for (Course course: courseRepository.findAll()) {
//            courses.add(course);
//        }
        student.getCourses().add(courseRepository.findOne(4));
//        courses.add(courseRepository.findOne(3));

//        student.setCourses(courses);

        studentRepository.save(student);

        return student.toString();
    }

    private void addStudent(){
        studentRepository.save(new Student("Student1"));
        studentRepository.save(new Student("Student2"));
        studentRepository.save(new Student("Student3"));
    }

    private void addCourse()
    {
        courseRepository.save(new Course("Course1"));
        courseRepository.save(new Course("Course2"));
        courseRepository.save(new Course("Course3"));
    }
}
