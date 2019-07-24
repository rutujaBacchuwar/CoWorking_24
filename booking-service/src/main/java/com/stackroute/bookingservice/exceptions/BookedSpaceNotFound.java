package com.stackroute.bookingservice.exceptions;

public class BookedSpaceNotFound extends Exception{

    String message;

    public BookedSpaceNotFound(String message) {
        super(message);
        this.message = message;
    }
}
