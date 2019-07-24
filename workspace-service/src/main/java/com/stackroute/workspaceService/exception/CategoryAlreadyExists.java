package com.stackroute.workspaceService.exception;


public class CategoryAlreadyExists extends Exception {
    String message;

    public CategoryAlreadyExists() {
    }

    public CategoryAlreadyExists(String message) {
        super(message);
        this.message = message;
    }
}
