package com.learningstuff.jwtspringbootsecuritydemo.security;

import com.learningstuff.jwtspringbootsecuritydemo.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private String secretKey = "secret";

    public User validate(String token) {
        User user = null;

        try{
            Claims body = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();

            user = new User();

            user.setId(Long.parseLong(body.get("userId").toString()));
            user.setUserName(body.getSubject());
            user.setRole(body.get("role").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        return user;
    }
}
