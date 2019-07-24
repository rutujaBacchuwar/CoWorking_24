package com.stackroute.bookingservice.service;

import com.stackroute.kafka.domain.CardDetails;


public interface CardService {

   CardDetails saveCardDetails(CardDetails cardDetails);

}