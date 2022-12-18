package com.projects.MaliSender;

import dto.MailDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailSenderService {
    private final JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String sendEmail(MailDto mail){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("yourmail@gmail.com");
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getBody());
        message.setSentDate(new Date());
        mailSender.send(message);

        return "MAIL SENT TO " + mail.getTo();
    }

}