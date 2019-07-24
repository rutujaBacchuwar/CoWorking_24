package com.stackroute.userservice.controller;
import com.stackroute.kafka.domain.MyBookings;
import com.stackroute.userservice.service.BookingService;
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

    @PostMapping("book")
    public ResponseEntity<?> saveUserBookedDetails(@RequestBody MyBookings myBookings)   {
        ResponseEntity responseEntity;
        bookingService.saveUserBookedDetails(myBookings);
            responseEntity=new ResponseEntity<String>("Successfully saved details of user booked properties", HttpStatus.CREATED);
            return responseEntity;
    }

    @GetMapping("books")
    public ResponseEntity<?> getAllBookedSpaces() {
        return new ResponseEntity<List<MyBookings>>(bookingService.getAllBookedSpaces(), HttpStatus.OK);
    }

    @GetMapping("books/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){
        System.out.println("dsfddsgdhjm");
        ResponseEntity responseEntity=new ResponseEntity<List<MyBookings>>(bookingService.findByName(name), HttpStatus.OK);
        return responseEntity;
    }

}


