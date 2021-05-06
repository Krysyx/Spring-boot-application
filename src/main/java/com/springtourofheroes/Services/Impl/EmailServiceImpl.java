package com.springtourofheroes.Services.Impl;

import com.springtourofheroes.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMessage(String to, String subject, String text) {
        var message = new SimpleMailMessage();
        message.setFrom("no-reply@springboot.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        this.javaMailSender.send(message);
    }

}
