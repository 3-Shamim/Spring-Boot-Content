package com.learningstuff.jwtspringbootsecuritydemo.controller;

import com.learningstuff.jwtspringbootsecuritydemo.model.User;
import com.learningstuff.jwtspringbootsecuritydemo.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "token")
public class TokenController {

    @Autowired
    private JwtGenerator jwtGenerator;

    @PostMapping
    public String generate(@RequestBody User user) {

        return jwtGenerator.generate(user);
    }

}
