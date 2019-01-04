package com.learningstuff.springsecuritywithjwtwithdb.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learningstuff.springsecuritywithjwtwithdb.model.ApplicationUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static com.learningstuff.springsecuritywithjwtwithdb.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            ApplicationUser applicationUser = new ObjectMapper().readValue(request.getInputStream(), ApplicationUser.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(applicationUser.getEmail(), applicationUser.getPassword()));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        ApplicationUser principal = (ApplicationUser) authResult.getPrincipal();

        ZonedDateTime expirationTimeUTC = ZonedDateTime.now(ZoneOffset.UTC).plus(EXPIRATION_TIME, ChronoUnit.MILLIS);
        String token = Jwts.builder().setSubject(principal.getEmail())
                .setExpiration(Date.from(expirationTimeUTC.toInstant()))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();

        response.getWriter().write(token);
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}
