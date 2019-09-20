package com.learningstuff.jasperreportswithspringboot;

import com.learningstuff.jasperreportswithspringboot.service.EmployService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JasperReportsWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasperReportsWithSpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner runner (final EmployService employService) {
        return args -> {
            System.out.println(employService.generateReport());
        };
    }

}
