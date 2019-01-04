package com.learningstuff.completesingupandsingindemo;

import com.learningstuff.completesingupandsingindemo.Model.Users;
import com.learningstuff.completesingupandsingindemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
public class CLR implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... strings) throws Exception {
        userRepository.save(new Users("shamim",getEncryptedPass("shamim"),"ADMIN"));
        userRepository.save(new Users("user",getEncryptedPass("user"),"USER"));
    }

    private String getEncryptedPass(String pass)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(pass);
    }
}
