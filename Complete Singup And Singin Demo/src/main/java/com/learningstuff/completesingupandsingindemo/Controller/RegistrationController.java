package com.learningstuff.completesingupandsingindemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @RequestMapping(value = "/reg")
    public String registration(Model model)
    {
        model.addAttribute("title","Registration");
        return "Registration/registration";
    }
}
