package com.learningstuff.springbootsecuritywithdatabase.Service;

import com.learningstuff.springbootsecuritywithdatabase.Model.CustomUserDetails;
import com.learningstuff.springbootsecuritywithdatabase.Model.Users;
import com.learningstuff.springbootsecuritywithdatabase.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> usersOptional = usersRepository.findByName(username);

        usersOptional.orElseThrow(()-> new UsernameNotFoundException("UserName Not Found!"));

        return usersOptional.map(users -> new CustomUserDetails(users)).get();
    }
}
