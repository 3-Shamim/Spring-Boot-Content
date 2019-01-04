package com.learningstuff.livedatareadbyajax.controller;

import com.learningstuff.livedatareadbyajax.model.User;
import com.learningstuff.livedatareadbyajax.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public ModelAndView index()
    {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "add")
    public ModelAndView addData()
    {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user", new User());
        modelAndView.setViewName("add");

        return modelAndView;
    }

    @PostMapping(value = "add")
    public ModelAndView addDataProcess(@ModelAttribute User user)
    {
        ModelAndView modelAndView = new ModelAndView();

        userService.addDate(user);

        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }
    @GetMapping(value = "update")
    public ModelAndView updateData()
    {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user", new User());
        modelAndView.setViewName("update");

        return modelAndView;
    }

    @PostMapping(value = "update")
    public ModelAndView updateDataProcess(@ModelAttribute User user)
    {
        ModelAndView modelAndView = new ModelAndView();

        userService.updateData(user);

        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }

}
