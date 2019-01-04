package com.learningstuff.springbootsecuritywithdatabase.Repository;

import com.learningstuff.springbootsecuritywithdatabase.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}