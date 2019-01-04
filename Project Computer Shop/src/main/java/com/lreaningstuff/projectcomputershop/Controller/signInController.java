package com.lreaningstuff.projectcomputershop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "login")
public class signInController {

    @RequestMapping(value = "")
    public String signIn()
    {
        return "signupandsignin/sign-in";
    }
}
