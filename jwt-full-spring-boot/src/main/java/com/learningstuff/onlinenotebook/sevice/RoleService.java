package com.learningstuff.onlinenotebook.sevice;

import com.learningstuff.onlinenotebook.model.Role;
import com.learningstuff.onlinenotebook.repositroy.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findByRole(String role) {
        return roleRepository.findRoleByRole(role);
    }
}
