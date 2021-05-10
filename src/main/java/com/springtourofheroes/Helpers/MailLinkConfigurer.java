package com.springtourofheroes.Helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MailLinkConfigurer {
    @Autowired
    private Environment env;

    public String getEmailLink(String confirmationToken) {
        return this.env.getProperty("mail.link") + confirmationToken;
    }
}
