package com.springtourofheroes.Services.Impl;

import com.springtourofheroes.Classes.AccountActivationEmail;
import com.springtourofheroes.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMessage(AccountActivationEmail email) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
        messageHelper.setTo(email.getTo());
        messageHelper.setFrom("no-reply@springboot.com");
        messageHelper.setSubject(email.getSUBJECT());
        messageHelper.setText(email.getText(), true);
        javaMailSender.send(message);
    }

}
