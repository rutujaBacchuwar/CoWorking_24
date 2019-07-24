package com.stackroute.workspaceService.exception;


public class LocationAlreadyExists extends Exception {
    String message;

    public LocationAlreadyExists() {
    }

    public LocationAlreadyExists(String message) {
        super(message);
        this.message = message;
    }
}