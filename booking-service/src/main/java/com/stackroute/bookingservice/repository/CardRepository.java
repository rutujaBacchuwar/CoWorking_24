package com.stackroute.bookingservice.repository;

import com.stackroute.kafka.domain.CardDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends MongoRepository<CardDetails, Integer>{

//    public  CardDetails save(CardDetails cardDetails);
}


