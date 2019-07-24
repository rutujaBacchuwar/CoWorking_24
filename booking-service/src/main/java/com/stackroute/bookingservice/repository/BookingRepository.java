package com.stackroute.bookingservice.repository;

import com.stackroute.kafka.domain.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingRepository extends MongoRepository<Booking, Integer> {

//    Booking getByName(String name);
   // boolean existsByBookingId(int bookingId);
   // void deleteByBookingId(int bookingId);

    @Query("{'myUser.name':'?0'}")
    List<Booking> findByName(String name);
}
