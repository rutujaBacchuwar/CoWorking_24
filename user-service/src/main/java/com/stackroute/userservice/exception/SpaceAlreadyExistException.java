package com.stackroute.userservice.exception;

public class SpaceAlreadyExistException extends Exception {

    private String message;

    public SpaceAlreadyExistException() {
    }

    public SpaceAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
