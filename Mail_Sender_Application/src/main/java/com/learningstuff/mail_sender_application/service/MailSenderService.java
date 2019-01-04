package com.learningstuff.mail_sender_application.service;

import com.learningstuff.mail_sender_application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void SendMail(User user) {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(user.getEmail());
            helper.setSubject("Mail From Application Created By Shamim");
            helper.setText("Welcome to my mail sender!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(message);

    }

}
