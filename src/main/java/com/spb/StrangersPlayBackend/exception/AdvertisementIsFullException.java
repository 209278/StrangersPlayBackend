package com.spb.StrangersPlayBackend.exception;

public class AdvertisementIsFullException extends RuntimeException {
    public AdvertisementIsFullException(String message) {
        super(message);
    }
}
