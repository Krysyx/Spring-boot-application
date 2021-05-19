package com.springtourofheroes.Classes;

public class ValidatedAccount {
    private User user;
    private static final String MESSAGE = "Account successfully activated";

    public ValidatedAccount(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return MESSAGE;
    }
}
