package com.springtourofheroes.Classes;

import com.springtourofheroes.Config.MailConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountActivationEmail {
    @Autowired
    private MailConfigProperties mailConfigProperties;

    private static final String SUBJECT = "Account activation";
    private String text;

    public AccountActivationEmail(String confirmationToken) {
        String url = mailConfigProperties.getPath() + "/account/activation?token=" + confirmationToken;
        this.text = "There is one last step you need to do in order to activate your account, click on the link below : "
                + "<a href='" + url + "'>" + "Activate your account" + "</a>";
    }


    public String getSUBJECT() {
        return SUBJECT;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
