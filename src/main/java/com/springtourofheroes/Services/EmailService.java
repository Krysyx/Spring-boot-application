package com.springtourofheroes.Services;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface EmailService {
    abstract void sendMessage(String to, String subject, String text) throws MessagingException;
}
