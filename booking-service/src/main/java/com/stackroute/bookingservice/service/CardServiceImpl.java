package com.stackroute.bookingservice.service;


import com.stackroute.kafka.domain.CardDetails;
import com.stackroute.bookingservice.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository){

        this.cardRepository = cardRepository;
    }


    @Override
    public CardDetails saveCardDetails(CardDetails cardDetails) {
        return cardRepository.save(cardDetails);
    }


}
