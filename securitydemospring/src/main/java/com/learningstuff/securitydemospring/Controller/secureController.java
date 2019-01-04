package com.learningstuff.securitydemospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class secureController {

    @RequestMapping(value = "adminPage")
    public String adminPage(Model model)
    {
        model.addAttribute("title", "Admin page!");
        return "adminPage";
    }
    @RequestMapping(value = "userPage")
    public String userPage(Model model)
    {
        model.addAttribute("title", "User page!");
        return "userPage";
    }

}
