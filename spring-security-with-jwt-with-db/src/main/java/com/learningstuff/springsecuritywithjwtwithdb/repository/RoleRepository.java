package com.learningstuff.springsecuritywithjwtwithdb.repository;

import com.learningstuff.springsecuritywithjwtwithdb.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleByRole(String role);
}
