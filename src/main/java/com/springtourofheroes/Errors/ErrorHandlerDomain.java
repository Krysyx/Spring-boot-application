package com.springtourofheroes.Errors;

public class ErrorHandlerDomain {
    private String message;
    private int statusCode;

    public ErrorHandlerDomain(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }


    public int getStatusCode() {
        return statusCode;
    }
}
