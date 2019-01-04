package com.learningstuff.onlinenotebook.controller;

import com.learningstuff.onlinenotebook.exception.AuthenticationException;
import com.learningstuff.onlinenotebook.model.JwtAuthenticationRequest;
import com.learningstuff.onlinenotebook.model.User;
import com.learningstuff.onlinenotebook.security.JwtTokenUtil;
import com.learningstuff.onlinenotebook.security.SecurityConstants;
import com.learningstuff.onlinenotebook.sevice.CustomUserDetailsService;
import com.learningstuff.onlinenotebook.sevice.RoleService;
import com.learningstuff.onlinenotebook.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping(value = "auth")
public class AuthenticationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping(value = "create-token")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authRequest, HttpServletResponse httpServletResponse) {

        authenticate(authRequest.getUsername(), authRequest.getPassword());

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);

//        httpServletResponse.setHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);

        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

    @PostMapping(value = "create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        user.setUserPassword(new BCryptPasswordEncoder().encode(user.getUserPassword()));
        user.setRoles(Arrays.asList(roleService.findByRole("USER")));

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }


    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationExcetion(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    private void authenticate(String username, String password) {
        Objects.nonNull(username);
        Objects.nonNull(password);
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("User is disabled!", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Bad credentials", e);
        }
    }


}
