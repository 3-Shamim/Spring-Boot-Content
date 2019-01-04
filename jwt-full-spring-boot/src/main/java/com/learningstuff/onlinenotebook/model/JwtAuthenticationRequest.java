package com.learningstuff.onlinenotebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtAuthenticationRequest {

    private String username;
    private String password;

}
