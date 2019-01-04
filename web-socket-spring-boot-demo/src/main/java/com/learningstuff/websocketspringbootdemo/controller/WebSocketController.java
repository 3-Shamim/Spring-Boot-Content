package com.learningstuff.websocketspringbootdemo.controller;

import com.learningstuff.websocketspringbootdemo.model.Contact;
import com.learningstuff.websocketspringbootdemo.model.Notify;
import com.learningstuff.websocketspringbootdemo.model.User;
import com.learningstuff.websocketspringbootdemo.repository.UserRepository;
import com.learningstuff.websocketspringbootdemo.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class WebSocketController {

    private ContactService contactService;
    private UserRepository userRepository;
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping(value = "/contact.{userName}")
    @SendTo(value = "/topic/contact-list")
    private Contact getContact(Contact contact, @DestinationVariable(value = "userName") String userName) throws InterruptedException {

        Thread.sleep(500);

        contact.setTime(LocalDateTime.now());

        System.out.println(userName);

        Optional<User> user = userRepository.findById(userName);

        System.out.println(user);

        user.ifPresent(contact::setUser);

        Contact saveContact = contactService.saveContact(contact);

        return saveContact;
    }

    @MessageMapping(value = "/user.{userName}")
    private void userNotify(@Payload Notify msg, @DestinationVariable(value = "userName") String userName) {

        System.out.println(msg);
        simpMessagingTemplate.convertAndSendToUser(userName, "/queue/user-notify", msg);
    }

//    @MessageMapping(value = "/contact1")
//    @SendTo(value = "/topic/contact-list1")
//    private Contact getContact1(Contact contact) throws InterruptedException {
//        Thread.sleep(500);
//        return contact;
//    }

    @GetMapping("/csrf")
    public @ResponseBody
    String getCsrfToken(HttpServletRequest request) {
        CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        return csrf.getToken();
    }



}
