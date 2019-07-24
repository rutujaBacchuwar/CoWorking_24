package com.stackroute.workspaceService.exception;


public class LocationNotFoundException extends Exception {
    String message;

    public LocationNotFoundException() {
    }

    public LocationNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
