package com.learningstuff.websocketspringbootdemo.controller;

import com.learningstuff.websocketspringbootdemo.model.Contact;
import com.learningstuff.websocketspringbootdemo.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class ViewController {

    private ContactService contactService;

    @GetMapping(value = "/")
    private ModelAndView contactView(ModelAndView modelAndView, Principal principal) {

        modelAndView.addObject("title", "Contact");
        modelAndView.addObject("contact", new Contact());
        modelAndView.addObject("userName", principal.getName());

        modelAndView.setViewName("contact");
        return modelAndView;
    }

    @GetMapping(value = "/contact-list")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ModelAndView contactListView(ModelAndView modelAndView) {

        modelAndView.addObject("title", "Contact List");
        modelAndView.addObject("contacts", contactService.findAllContactOrderByTimeDesc());
        modelAndView.addObject("unseenContactCount", contactService.countUnseenContact());

        modelAndView.setViewName("contact_list");
        return modelAndView;
    }

    @GetMapping(value = "/denied")
    @ResponseBody
    public String deniedView() {
        return "Access Denied!";
    }

    @GetMapping(value = "/test")
    @ResponseBody
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String text() {

        contactService.findAllContactOrderByTimeDesc().forEach(System.out::println);

        return "Access!";
    }
}
