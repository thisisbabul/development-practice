package com.example.authservice.exception;

public class AuthException extends RuntimeException {
    public AuthException() {
    }

    public AuthException(String message) {
        super(message);
    }
}
