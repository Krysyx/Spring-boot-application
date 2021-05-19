package com.springtourofheroes.Classes;

public class TokenValidity {
    private String id;
    private boolean isValid;

    public TokenValidity(String id, boolean isValid) {
        this.id = id;
        this.isValid = isValid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
