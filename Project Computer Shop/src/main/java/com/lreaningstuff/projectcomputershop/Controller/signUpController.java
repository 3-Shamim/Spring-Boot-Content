package com.lreaningstuff.projectcomputershop.Controller;

import com.lreaningstuff.projectcomputershop.Model.Users;
import com.lreaningstuff.projectcomputershop.Services.userService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "registration")
public class signUpController {

    private userService userService = new userService();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String registration(Model model)
    {
        model.addAttribute(new Users());
        return "signupandsignin/sign-up";
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute Users users, Model model)
    {
        userService.saveUser(users);
        return "redirect:/registration/regValue";
    }

    // for test
    @RequestMapping(value = "regValue")
    @ResponseBody
    public String regValue()
    {
        return userService.getUser().toString();
    }
}
