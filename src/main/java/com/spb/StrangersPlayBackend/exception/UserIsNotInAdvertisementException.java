package com.spb.StrangersPlayBackend.exception;

public class UserIsNotInAdvertisementException extends RuntimeException {
    public UserIsNotInAdvertisementException(String message) {
        super(message);
    }
}
