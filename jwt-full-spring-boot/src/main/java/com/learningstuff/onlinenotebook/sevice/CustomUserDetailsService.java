package com.learningstuff.onlinenotebook.sevice;

import com.learningstuff.onlinenotebook.model.User;
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

        Optional<User> optionalUser = findUserByEmail(email);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User Not Found Exception"));


        return optionalUser.get();
    }

    public Optional<User> findUserByEmail(String email) {
        return userService.findUserByEmail(email);
    }
}
