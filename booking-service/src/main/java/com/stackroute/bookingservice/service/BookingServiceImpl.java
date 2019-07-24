package com.stackroute.bookingservice.service;


import com.stackroute.kafka.domain.Booking;
import com.stackroute.bookingservice.exceptions.BookedSpaceNotFound;
import com.stackroute.bookingservice.exceptions.SpaceAlreadyBooked;
import com.stackroute.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingServiceImpl implements BookingService{
    BookingRepository bookingRepository;


    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookedSpace() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking bookedSpace(Booking booking) throws SpaceAlreadyBooked {
        Booking bookedSpace = bookingRepository.save(booking);
        return bookedSpace;
    }

//    @Override
//    public boolean deleteBookedSpace(int bookingId) throws BookedSpaceNotFound {
//        boolean status = false;
//        System.out.println("***********bookingidddd" + bookingId);
//        if (bookingRepository.existsByBookingId(bookingId)) {
//            bookingRepository.deleteByBookingId(bookingId);
//            status = true;
//            return status;
//        } else {
//            throw new BookedSpaceNotFound("Booked Space Not exists");
//        }
//
//    }

    @Override
    public List<Booking> findByName(String name) {
        return bookingRepository.findByName(name);
    }


}
