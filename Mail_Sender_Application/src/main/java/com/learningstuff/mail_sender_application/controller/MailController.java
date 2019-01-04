package com.learningstuff.mail_sender_application.controller;

import com.learningstuff.mail_sender_application.model.User;
import com.learningstuff.mail_sender_application.service.MailSenderService;
import com.learningstuff.mail_sender_application.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private MailSenderService mailSenderService;

    @GetMapping(value = "signup")
    public String signUp() {
        return "Sign Up";
    }

    @GetMapping(value = "signup_success")
    public String signUpSuccess() {

        // Send a notification

        User user = new User(1, "Shamim", "mdshamim723@gmail.com");

        try {
            notificationService.sendNotification(user);

//            mailSenderService.SendMail(user);
        } catch (MailException e) {
            e.printStackTrace();
        }

        return "Sign Up Success";
    }

}
