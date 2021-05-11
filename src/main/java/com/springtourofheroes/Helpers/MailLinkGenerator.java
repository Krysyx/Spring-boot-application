package com.springtourofheroes.Helpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailLinkGenerator {
    @Value("${mail.link}")
    private String emailLink;

    public String getEmailLink(String confirmationToken) {
        return this.emailLink + confirmationToken;
    }
}
