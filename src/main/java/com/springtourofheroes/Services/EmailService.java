package com.springtourofheroes.Services;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    abstract void sendMessage(String to, String subject, String text);
}
