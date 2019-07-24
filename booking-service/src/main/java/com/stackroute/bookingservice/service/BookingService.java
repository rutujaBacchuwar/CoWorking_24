package com.stackroute.bookingservice.service;

import com.stackroute.kafka.domain.Booking;
import com.stackroute.bookingservice.exceptions.BookedSpaceNotFound;
import com.stackroute.bookingservice.exceptions.SpaceAlreadyBooked;

import java.util.List;

public interface BookingService {

    public List<Booking> getAllBookedSpace();
    public Booking bookedSpace(Booking booking) throws SpaceAlreadyBooked;
   // public boolean deleteBookedSpace(int bookingId) throws BookedSpaceNotFound;
    public List<Booking> findByName(String name);
}
