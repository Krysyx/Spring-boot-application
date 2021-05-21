package com.springtourofheroes.Classes;

public class ValidatedToken {
    private String userId;
    private static final boolean isValid = true;

    public ValidatedToken(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public final boolean isIsValid() {
        return isValid;
    }
}
