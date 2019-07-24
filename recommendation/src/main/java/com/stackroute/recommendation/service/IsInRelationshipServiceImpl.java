package com.stackroute.recommendation.service;


import com.stackroute.recommendation.domain.IsIn;
import com.stackroute.recommendation.domain.Space;
import com.stackroute.recommendation.repository.IsInRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class IsInRelationshipServiceImpl implements IsInRelationshipService {

    IsInRelationshipRepository isInRelationshipRepository;

    @Autowired
    public IsInRelationshipServiceImpl(IsInRelationshipRepository isInRelationshipRepository) {
        this.isInRelationshipRepository = isInRelationshipRepository;
    }


    @Override
    public Collection<IsIn> getRelationship() {
        return isInRelationshipRepository.getRelationship();
    }

    @Override
    public IsIn createrelationship(String locationName,String cityName) {
        return isInRelationshipRepository.createRelationship(locationName,cityName);
    }

    @Override
    public Collection<Space> getSpaceWithCity(String cityName) {
        return isInRelationshipRepository.getSpaceCity(cityName);
    }
}
