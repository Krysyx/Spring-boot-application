package com.springtourofheroes.Classes;

import javax.validation.constraints.Email;

public class AccountActivationEmail {
    @Email
    private final String to;
    private static final String SUBJECT = "Account activation";
    private final String text;

    public AccountActivationEmail(String to, String link) {
        this.to = to;
        this.text = "There is one last step you need to do in order to activate your account, click on the following link : "
                + "<a href='" + link + "'>" + "Activate your account" + "</a>";
    }

    public String getSUBJECT() {
        return SUBJECT;
    }

    public String getText() {
        return text;
    }

    public String getTo() {
        return to;
    }
}
