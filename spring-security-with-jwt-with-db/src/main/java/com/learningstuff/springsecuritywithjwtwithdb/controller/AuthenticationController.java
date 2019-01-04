package com.learningstuff.springsecuritywithjwtwithdb.controller;


import com.learningstuff.springsecuritywithjwtwithdb.model.ApplicationUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "token")
public class AuthenticationController {

    @PostMapping(value = "")
    public UsernamePasswordAuthenticationToken getToken(@RequestBody ApplicationUser applicationUser) {
        return new UsernamePasswordAuthenticationToken(applicationUser.getEmail(), applicationUser.getPassword());

    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }



}
