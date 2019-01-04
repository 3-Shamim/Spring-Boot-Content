package com.learningstuff.livedatareadbyajax.controller;

import com.learningstuff.livedatareadbyajax.model.User;
import com.learningstuff.livedatareadbyajax.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> allUser()
    {
        return userService.userList();
    }


}
