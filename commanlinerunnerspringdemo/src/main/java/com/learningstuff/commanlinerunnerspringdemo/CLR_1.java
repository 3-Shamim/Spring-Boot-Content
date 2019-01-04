package com.learningstuff.commanlinerunnerspringdemo;

import com.learningstuff.commanlinerunnerspringdemo.Model.User;
import com.learningstuff.commanlinerunnerspringdemo.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
//@Order(value = 2)
public class CLR_1 implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    private final Logger logger = LoggerFactory.getLogger(CLR_1.class);

    @Override
    public void run(String... strings) throws Exception {
        logger.info("CLR_1 loader...");
        userRepository.save(new User("User1"));
        userRepository.save(new User("User2"));
        userRepository.save(new User("User3"));
        userRepository.save(new User(getEnryptedPassword()));
    }

    private String getEnryptedPassword(){
        passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode("abc");
    }
}
