package com.learningstuff.springsecuritywithjwtwithdb.services;

import com.learningstuff.springsecuritywithjwtwithdb.model.ApplicationUser;
import com.learningstuff.springsecuritywithjwtwithdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<ApplicationUser> getUserByEmail(String email) {
        return userRepository.findById(email);
    }

    public void createUser(ApplicationUser user) {
        userRepository.save(user);
    }

}
