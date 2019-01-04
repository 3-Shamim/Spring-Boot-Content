package com.learningstuff.commanlinerunnerspringdemo.Repository;

import com.learningstuff.commanlinerunnerspringdemo.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


//@Component
//@Order(value = 1)
public class CLR_2 implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    private final Logger logger = (Logger) LoggerFactory.getLogger(CLR_2.class);

    @Override
    public void run(String... strings) throws Exception {
        logger.info("CLR_2 Loader....");
        userRepository.save(new User("User4"));
        userRepository.save(new User("User5"));
        userRepository.save(new User("User6"));
    }
}
