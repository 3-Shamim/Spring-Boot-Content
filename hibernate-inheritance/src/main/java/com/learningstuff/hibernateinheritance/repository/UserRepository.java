package com.learningstuff.hibernateinheritance.repository;

import com.learningstuff.hibernateinheritance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository<T extends User> extends JpaRepository<T, User> {

    Optional<User> findUserByEmail(String email);
    void deleteUserByEmail(String email);

}
