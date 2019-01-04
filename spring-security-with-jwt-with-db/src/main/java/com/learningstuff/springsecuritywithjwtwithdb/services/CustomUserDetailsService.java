package com.learningstuff.springsecuritywithjwtwithdb.services;

import com.learningstuff.springsecuritywithjwtwithdb.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<ApplicationUser> userOptional = loadApplicationUserByUserName(email);

        userOptional.orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));

        return userOptional.get();
    }


    /*@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        ApplicationUser applicationUser = loadApplicationUserByUserName(email);

        return new User(applicationUser.getUserName(), applicationUser.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
    }*/

    public Optional<ApplicationUser> loadApplicationUserByUserName(String email) {
        return userService.getUserByEmail(email);
    }

}
