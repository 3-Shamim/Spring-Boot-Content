package com.learningstuff.websocketspringbootdemo;

import com.learningstuff.websocketspringbootdemo.model.Role;
import com.learningstuff.websocketspringbootdemo.model.User;
import com.learningstuff.websocketspringbootdemo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class WebSocketSpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketSpringBootDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository) {
        return args -> {

            userRepository.saveAll(Arrays.asList(
                    new User("admin", Role.ADMIN),
                    new User("user1", Role.USER),
                    new User("user2", Role.USER),
                    new User("user3", Role.USER)
            ));

        };
    }
}
