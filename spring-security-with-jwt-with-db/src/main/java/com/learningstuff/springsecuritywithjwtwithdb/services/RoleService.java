package com.learningstuff.springsecuritywithjwtwithdb.services;

import com.learningstuff.springsecuritywithjwtwithdb.model.Role;
import com.learningstuff.springsecuritywithjwtwithdb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleByRole(String role) {
        return roleRepository.findRoleByRole(role);
    }

}
