package com.learningstuff.hibernateinheritance.repository;

import com.learningstuff.hibernateinheritance.model.Employee;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface EmployeeRepository extends UserRepository<Employee> {
}
