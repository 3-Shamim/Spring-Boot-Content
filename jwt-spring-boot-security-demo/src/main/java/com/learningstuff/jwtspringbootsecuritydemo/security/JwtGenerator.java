package com.learningstuff.jwtspringbootsecuritydemo.security;

import com.learningstuff.jwtspringbootsecuritydemo.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {


    public String generate(User user) {

        Claims claims = Jwts.claims()
                .setSubject(user.getUserName());
        claims.put("userId", user.getId().toString());
        claims.put("role", user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, "secret")
                .compact();
    }
}
