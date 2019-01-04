package com.learningstuff.springbootsecuritywithdatabase;

import com.learningstuff.springbootsecuritywithdatabase.Model.Role;
import com.learningstuff.springbootsecuritywithdatabase.Model.Users;
import com.learningstuff.springbootsecuritywithdatabase.Repository.RoleRepository;
import com.learningstuff.springbootsecuritywithdatabase.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

//@Component
public class CLR implements CommandLineRunner {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... strings) throws Exception {
        roleRepository.save(new Role("ADMIN"));
        usersRepository.save(new Users("Shamim@gmail.com",getEncyptedPassword(),"Shamim"));
        Users users = usersRepository.findOne(1);
        Role role = roleRepository.findOne(1);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        users.setRoles(roles);
        usersRepository.save(users);
    }

    private String getEncyptedPassword()
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode("shamim");
    }
}
