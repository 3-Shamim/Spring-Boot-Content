package com.learningstuff.completesingupandsingindemo.Services;

import com.learningstuff.completesingupandsingindemo.Model.CustomUserDetails;
import com.learningstuff.completesingupandsingindemo.Model.Users;
import com.learningstuff.completesingupandsingindemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // Find The User
        Optional<Users> usersOptional = userRepository.findByName(userName);
        // Throw Exception if user not found
        usersOptional.orElseThrow(() -> new UsernameNotFoundException("UserName Not Found !"));
        // If user found then make it as a UserDetails and return
        CustomUserDetails customUserDetails = usersOptional.map(users1 -> {
            return new CustomUserDetails(users1);
        }).get();

        return customUserDetails;

        // This is another way to return UserDetails with lamda
        /*return usersOptional.map(users -> new CustomUserDetails(users)
        ).get();*/
    }
}
