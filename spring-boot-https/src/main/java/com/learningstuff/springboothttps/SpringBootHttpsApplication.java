package com.learningstuff.springboothttps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootHttpsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHttpsApplication.class, args);
    }

}


@RestController
class DemoController {

    @GetMapping
    public String demoHttps() {

        return "Now your are with HTTPS";
    }

}
