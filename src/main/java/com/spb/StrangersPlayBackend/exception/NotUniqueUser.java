package com.spb.StrangersPlayBackend.exception;

public class NotUniqueUser extends RuntimeException {
    public NotUniqueUser(String message) {
        super(message);
    }
}
