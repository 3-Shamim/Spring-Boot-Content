package com.learningstuff.springbootsecuritywithdatabase.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "rest")
public class HelloController {

    @GetMapping("hello")
    @ResponseBody
    public String hello()
    {
        return "Hello I'm ok";
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("secure/hello")
    @ResponseBody
    public String secureHello()
    {
        return "Secure Hello Admin";
    }
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("secure/hello1")
    @ResponseBody
    public String secureHello1()
    {
        return "Secure Hello User";
    }
}
