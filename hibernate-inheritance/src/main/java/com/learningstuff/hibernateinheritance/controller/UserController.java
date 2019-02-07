package com.learningstuff.hibernateinheritance.controller;

import com.learningstuff.hibernateinheritance.model.Customer;
import com.learningstuff.hibernateinheritance.model.Employee;
import com.learningstuff.hibernateinheritance.model.User;
import com.learningstuff.hibernateinheritance.repository.CustomerRepository;
import com.learningstuff.hibernateinheritance.repository.EmployeeRepository;
import com.learningstuff.hibernateinheritance.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;

    @GetMapping(value = "add-all")
    public ResponseEntity<?> setupData() {

        /* Add User */
        userRepository.save(new User("admin@mail.com", "123456"));


        /* Add Customer */
        Customer customer = new Customer();
        customer.setEmail("customer@mail.com");
        customer.setPassword("123456");
        customer.setName("Customer");
        customer.setAddress("address");
        customer.setPhone("0158-98----");

        customerRepository.save(customer);

        /* Add Employee */
        Employee employee1 = new Employee("Employee1", "address1", "654987-654--");
        employee1.setEmail("employee1@mail.com");
        employeeRepository.save(employee1);

        Employee employee = new Employee();
        employee.setEmail("employee@mail.com");
        employee.setPassword("123456");
        employee.setName("Employee2");
        employee.setAddress("adderss2");
        employee.setPhone("654-54465--");
        employeeRepository.save(employee);

        return ResponseEntity.ok().body("SuccessFully Added");

    }

    @GetMapping(value = "all-customer")
    public ResponseEntity<?> getAllCustomer() {
        return ResponseEntity.ok().body(customerRepository.findAll());
    }

    @GetMapping(value = "all-employee")
    public ResponseEntity<?> getAllEmployee() {
        return ResponseEntity.ok().body(employeeRepository.findAll());
    }

    @GetMapping(value = "all-user")
    public ResponseEntity<?> getAllUser () {
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @PostMapping(value = "save-employee")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {

        Employee saveEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok().body(saveEmployee);
    }

    @PostMapping(value = "save-customer")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {

        Customer saveCustomer = customerRepository.save(customer);

        return ResponseEntity.ok().body(saveCustomer);
    }

    @PostMapping(value = "save-user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {

        Object saveUser = userRepository.save(user);

        return ResponseEntity.ok().body(saveUser);
    }

    @DeleteMapping("user-delete/{email}")
    public ResponseEntity<?> userDelete(@PathVariable(value = "email") String email) {

        Optional<User> optional = userRepository.findUserByEmail(email);

        if (optional.isPresent()) {

            userRepository.deleteUserByEmail(optional.get().getEmail());

            return ResponseEntity.ok().body("User Successfully Deleted");
        }

        return ResponseEntity.badRequest().body("User Not found by " + email);
    }

    @DeleteMapping("customer-delete/{email}")
    public ResponseEntity<?> customerDelete(@PathVariable(value = "email") String email) {

        customerRepository.deleteCustomerByEmail(email);

        return ResponseEntity.ok().body("Customer Successfully Deleted");
    }


}
