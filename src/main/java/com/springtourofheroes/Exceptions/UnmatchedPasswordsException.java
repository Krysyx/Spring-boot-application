package com.springtourofheroes.Exceptions;

public class UnmatchedPasswordsException extends RuntimeException {
    public UnmatchedPasswordsException(String message) {
        super(message);
    }
}
