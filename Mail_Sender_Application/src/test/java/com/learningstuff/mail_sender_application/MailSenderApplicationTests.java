package com.learningstuff.mail_sender_application;

import com.learningstuff.mail_sender_application.model.User;
import com.learningstuff.mail_sender_application.service.MailSenderService;
import com.learningstuff.mail_sender_application.service.NotificationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailSenderApplicationTests {

	@Autowired
	private NotificationService notificationService;
	@Autowired
	private MailSenderService mailSenderService;

	@Test
	public void contextLoads() {

		User user = new User(1, "Shamim", "mdshamim723@gmail.com");
		User user1 = new User(1, "Rajon", "rajonrj009@gmail.com");
		User user2 = new User(1, "Sourav", "sourav575744@gmail.com ");

		try {
//			notificationService.sendNotification(user);
            mailSenderService.SendMail(user);
//            mailSenderService.SendMail(user2);
		} catch (MailException e) {
			e.printStackTrace();
		}
	}

//	@Test
//    public void test1(){
//        User user2 = new User(1, "Sourav", "sourav575744@gmail.com ");
//
//        try {
//            mailSenderService.SendMail(user2);
//        } catch (MailException e) {
//            e.printStackTrace();
//        }
//    }

}
