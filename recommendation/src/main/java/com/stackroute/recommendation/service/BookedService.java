package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface BookedService {
    public Collection<User> getRelationship();
    public User createRelationship(String name, String categoryName,long spaceId);
    public User deleteRelationship();
}
