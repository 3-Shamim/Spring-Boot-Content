package com.learningstuff.springsecuritywithjwtwithdb.repository;

import com.learningstuff.springsecuritywithjwtwithdb.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, String> {
}
