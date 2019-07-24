package com.stackroute.userservice.exception;

public class SpaceNotFound extends Exception {

    private String message;

    public SpaceNotFound(){}

    public SpaceNotFound(String message) {
        super(message);
        this.message = message;
    }

}
