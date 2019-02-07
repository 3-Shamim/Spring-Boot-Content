package com.learningstuff.hibernateinheritance.repository;

import com.learningstuff.hibernateinheritance.model.Customer;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface CustomerRepository extends UserRepository<Customer> {

    Optional<Customer> findCustomerByEmail(String email);

    void deleteCustomerByEmail(String email);
}
