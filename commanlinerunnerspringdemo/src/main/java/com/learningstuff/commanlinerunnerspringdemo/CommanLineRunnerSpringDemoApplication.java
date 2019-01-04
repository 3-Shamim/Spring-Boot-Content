package com.learningstuff.commanlinerunnerspringdemo;

import com.learningstuff.commanlinerunnerspringdemo.Model.User;
import com.learningstuff.commanlinerunnerspringdemo.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommanLineRunnerSpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommanLineRunnerSpringDemoApplication.class, args);
	}

	/*@Bean
	CommandLineRunner runner(UserRepository userRepository){
	    return args -> {
            userRepository.save(new User("User1"));
            userRepository.save(new User("User2"));
            userRepository.save(new User("User3"));
        };
    }*/
}
