package com.stackroute.userservice.service;
import com.stackroute.kafka.domain.MyBookings;
import com.stackroute.userservice.repository.BookingRepository;
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
    public List<MyBookings> getAllBookedSpaces() {
        return bookingRepository.findAll();
    }

    @Override
    public MyBookings saveUserBookedDetails(MyBookings myBookings)  {
        MyBookings bookedSpace = bookingRepository.save(myBookings);
        return bookedSpace;
    }

    @Override
    public List<MyBookings> findByName(String name) {
        System.out.println("in service implementation");
        return bookingRepository.findByName(name);
    }

}
