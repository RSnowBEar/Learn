package com.CustomException;

public class UserRentException extends RuntimeException {
    public UserRentException(String message) {
        super(message);
    }
}
