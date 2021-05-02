package com.springtourofheroes.Errors;

public class ErrorHandlerDomain {
    private String reason;
    private String message;
    private int statusCode;

    public ErrorHandlerDomain(String reason, String message, int statusCode) {
        this.reason = reason;
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
