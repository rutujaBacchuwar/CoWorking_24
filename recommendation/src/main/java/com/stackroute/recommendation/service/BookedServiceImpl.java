package com.stackroute.recommendation.service;


import com.stackroute.recommendation.domain.User;
import com.stackroute.recommendation.repository.BookedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookedServiceImpl implements BookedService {

    BookedRepository bookedRepository;

    @Autowired
    public BookedServiceImpl(BookedRepository bookedRepository) {
        this.bookedRepository = bookedRepository;
    }

    @Override
    public Collection<User> getRelationship() {
        return bookedRepository.getRelationship();
    }

    @Override
    public User createRelationship(String name, String categoryName,long spaceId) {
        return bookedRepository.createRelationship(name,categoryName,spaceId);
    }

    @Override
    public User deleteRelationship() {
        return bookedRepository.deleteRelationship();
    }
}
