package com.springtourofheroes.Classes;

public class AccountActivationEmail {
    private static final String SUBJECT = "Account activation";
    private String text;

    public AccountActivationEmail(String confirmationToken) {
        this.text = "There is one last step you need to do in order to activate your account : " + "http://127.0.0.1:8080/account/activation?token=" + confirmationToken;
    }

    public static String getSUBJECT() {
        return SUBJECT;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
