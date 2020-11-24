package com.CustomException;

public class UserRegisterException extends RuntimeException {
    public UserRegisterException(String message) {
        super(message);
    }
}
