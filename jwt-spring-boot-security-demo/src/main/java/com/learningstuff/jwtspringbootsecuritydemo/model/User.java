package com.learningstuff.jwtspringbootsecuritydemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Long id;
    private String userName;
    private String role;

}
