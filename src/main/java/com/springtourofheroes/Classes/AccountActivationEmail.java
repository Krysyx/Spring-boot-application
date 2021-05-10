package com.springtourofheroes.Classes;

public class AccountActivationEmail {

    private static final String SUBJECT = "Account activation";
    private final String confirmationToken;
    private String text;

    public AccountActivationEmail(String confirmationToken) {
        this.confirmationToken = confirmationToken;
//        this.text = "There is one last step you need to do in order to activate your account, click on the link below : "
//                + "<a href='" + this.mailConfigProperties.getEnvironmentProperties() + "'>" + "Activate your account" + "</a>";
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
