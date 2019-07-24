package com.stackroute.userservice.service;
import com.stackroute.kafka.domain.MyBookings;
import java.util.List;

public interface BookingService {
    public MyBookings saveUserBookedDetails(MyBookings myBookings);
    public List<MyBookings> getAllBookedSpaces() ;
    public List<MyBookings> findByName(String name);
}
