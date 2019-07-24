package com.stackroute.bookingservice.controller;

import com.stackroute.kafka.domain.*;
import com.stackroute.bookingservice.exceptions.BookedSpaceNotFound;
import com.stackroute.bookingservice.exceptions.SpaceAlreadyBooked;
import com.stackroute.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/v1")
public class BookingController {


    @Autowired
    BookingService bookingService;

    MyUser myuser=new MyUser();
    MyUser myuser1=new MyUser();
    MyCategory myCategory=new MyCategory();
    MySpace mySpace=new MySpace();
    Booking booking=new Booking();

    @Autowired
    Producer producer;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("book")
    public ResponseEntity<?> bookedSpace(@RequestBody Booking booking) throws BookedSpaceNotFound {


        System.out.println("Booking object:"+booking.toString() );


        ResponseEntity responseEntity;
        try {
            bookingService.bookedSpace(booking);
            responseEntity = new ResponseEntity<Booking>( booking , HttpStatus.CREATED);
            producer.send(booking);
            producer.send1(booking);
        } catch (SpaceAlreadyBooked ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;
    }


    @GetMapping("books")
    public ResponseEntity<?> getAllBookedSpace() {
        return new ResponseEntity<List<Booking>>(bookingService.getAllBookedSpace(), HttpStatus.OK);
    }



//    @DeleteMapping("book/{bookingId}")
//    public ResponseEntity<?> deleteBookedSpace(@PathVariable("bookingId") int bookingId) throws BookedSpaceNotFound {
//        {
//            ResponseEntity responseEntity;
//            try {
//
//                responseEntity = new ResponseEntity<String>("Deleted Booked Space successfully", HttpStatus.OK);
//            } catch (BookedSpaceNotFound exception) {
//                responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
//            }
//            return responseEntity;
//        }
//
//    }

    @GetMapping("books/{name}")
    public ResponseEntity <List<Booking>> getByName(@PathVariable String name){
        System.out.println("dsfddsgdhjm");
        ResponseEntity responseEntity=new ResponseEntity<List<Booking>>(bookingService.findByName(name), HttpStatus.OK);
        return responseEntity;
    }

}
