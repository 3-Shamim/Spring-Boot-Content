package com.learningstuff.securitydemospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("check")
public class HomeController {

    /*@RequestMapping("/")
    @ResponseBody
    public String home()
    {
        return "Welcome in spring security!";
    }
    @RequestMapping("/admin/{adminName}")
    @ResponseBody
    public String admin(@PathVariable String adminName)
    {
        return "Welcome to Admin! Name : " + adminName;
    }
    @RequestMapping("/user/{userName}")
    @ResponseBody
    public String user(@PathVariable String userName)
    {
        return "Welcome to "+userName+"!";
    }*/

    @RequestMapping(value = "home")
    public String home(Model model)
    {
        model.addAttribute("title", "Home page!");
        return "home";
    }
    @RequestMapping(value = "userLogin")
    public String login(Model model)
    {
        model.addAttribute("title", "Login page!");
        return "LoginPage";
    }
    @RequestMapping(value = "404error")
    public String error(Model model)
    {
        model.addAttribute("title", "404error page!");
        return "404error";
    }
    @RequestMapping("checkrolebased")
    public String CheckRoleBased()
    {
        return "CheckRoleBased";
    }
}
