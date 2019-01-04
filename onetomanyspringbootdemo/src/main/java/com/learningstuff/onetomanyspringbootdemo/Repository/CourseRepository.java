package com.learningstuff.onetomanyspringbootdemo.Repository;

import com.learningstuff.onetomanyspringbootdemo.Model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CourseRepository extends CrudRepository<Course, Integer>{
}
