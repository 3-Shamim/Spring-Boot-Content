package com.learningstuff.completesingupandsingindemo.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "secure")
public class HomeController {

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "admin")
    public String home()
    {
        return "Home/home";
    }
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(value = "user")
    @ResponseBody
    public String homeUser()
    {
        return "I'm User";
    }
}
