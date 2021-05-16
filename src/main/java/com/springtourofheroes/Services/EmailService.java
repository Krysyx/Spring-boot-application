package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.AccountActivationEmail;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface EmailService {
    abstract void sendMessage(AccountActivationEmail email) throws MessagingException;
}
