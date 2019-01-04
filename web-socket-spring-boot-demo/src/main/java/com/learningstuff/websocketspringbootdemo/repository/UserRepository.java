package com.learningstuff.websocketspringbootdemo.repository;

import com.learningstuff.websocketspringbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
