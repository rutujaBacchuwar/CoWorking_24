package com.stackroute.bookingservice.controller;


import com.stackroute.kafka.domain.CardDetails;
import com.stackroute.bookingservice.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin("*")
public class CardDetailsController {


    private CardService cardService;

    @Autowired
    public CardDetailsController(CardService cardService){
        this.cardService=cardService;
    }



    @PostMapping("/cardDetails")
    public String saveCardDetails(@RequestBody CardDetails cardDetails){
        CardDetails cardDetails1 = cardService.saveCardDetails(cardDetails);
        ResponseEntity responseEntity=new ResponseEntity<Object>("Payment successful", HttpStatus.CREATED);
        return "payment successful";

    }


}
