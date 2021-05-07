package com.springtourofheroes.Classes;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Email;

public class AccountActivationEmail {
    @Email
    private String email;
    @Value(value = "Account activation")
    private String subject;
    //    @Value(value = "There is one last step you need to do in order to activate your account : " + "http://127.0.0.1:8080/account/activation?token=" + )
    private String text;

    public AccountActivationEmail(@Email String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
