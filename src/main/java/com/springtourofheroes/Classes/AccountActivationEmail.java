package com.springtourofheroes.Classes;

public class AccountActivationEmail {
    private static final String SUBJECT = "Account activation";
    private String text;

    public AccountActivationEmail(String link) {
        this.text = "There is one last step you need to do in order to activate your account, click on the following link : "
                + "<a href='" + link + "'>" + "Activate your account" + "</a>";
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
