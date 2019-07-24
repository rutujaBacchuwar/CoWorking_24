package com.stackroute.bookingservice.exceptions;

public class SpaceAlreadyBooked extends Exception  {
    String message;


    public SpaceAlreadyBooked(String message) {
        super(message);
        this.message = message;
    }




}
