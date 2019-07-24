package com.stackroute.workspaceService.exception;

public class CategoryNotFoundException extends Exception {
    String message;

    public CategoryNotFoundException() {
    }

    public CategoryNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
