package com.springtourofheroes.Exceptions;

public class InvalidInputExceptionHandler extends RuntimeException {

    public InvalidInputExceptionHandler(String message) {
        super(message);
    }

    public InvalidInputExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputExceptionHandler(Throwable cause) {
        super(cause);
    }
}
