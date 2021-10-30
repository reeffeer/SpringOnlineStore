package com.reef.demo_store.exceptions;

public class BadDataRequestException extends RuntimeException {
    public BadDataRequestException(String message) {
        super(message);
    }
}
