package com.learningstuff.springsecuritywithjwtwithdb;

import com.learningstuff.springsecuritywithjwtwithdb.model.ApplicationUser;
import com.learningstuff.springsecuritywithjwtwithdb.model.Role;
import com.learningstuff.springsecuritywithjwtwithdb.services.RoleService;
import com.learningstuff.springsecuritywithjwtwithdb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSecurityWithJwtWithDbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityWithJwtWithDbApplication.class, args);
    }

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    @Override
    public void run(String... args) throws Exception {

        List<Role> roles = new ArrayList<>();
        roles.add(new Role("USER"));

        ApplicationUser user = new ApplicationUser("user@mail.com","123456",roles);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.createUser(user);

        roles.clear();
        roles.add(new Role("ADMIN"));
        ApplicationUser admin = new ApplicationUser("admin@mail.com","123456", roles);
        admin.setPassword(new BCryptPasswordEncoder().encode(admin.getPassword()));
        userService.createUser(admin);

        roles.clear();
        roles.add(roleService.getRoleByRole("USER"));
        roles.add(roleService.getRoleByRole("ADMIN"));
        ApplicationUser admin1 = new ApplicationUser("admin1@mail.com","123456", roles);
        admin1.setPassword(new BCryptPasswordEncoder().encode(admin1.getPassword()));
        userService.createUser(admin1);
    }
}
