package com.stackroute.recommendation.service;


import com.stackroute.recommendation.domain.Category;
import com.stackroute.recommendation.domain.Space;
import com.stackroute.recommendation.repository.LocatedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LocatedServiceImpl implements LocatedService {

    LocatedRepository locatedRepository;

    @Autowired
    public LocatedServiceImpl(LocatedRepository locatedRepository) {
        this.locatedRepository = locatedRepository;
    }

    @Override
    public Collection<Space> getRelationship() {
        return locatedRepository.getRelationship();
    }

    @Override
    public Space createRelationship(String spaceName, String locationName) {
        return locatedRepository.createRelationship(spaceName,locationName);
    }

    @Override
    public Category createRelationshipLoc(String categoryName, String locationName) {
        return locatedRepository.createRelationshipLoc(categoryName,locationName);
    }

    @Override
    public Category deleteRelationshipcat() {
        return locatedRepository.deleteRelationshipcat();
    }

    @Override
    public Space deleteRelationship() {
        return locatedRepository.deleteRelationship();
    }

    @Override
    public Collection<Space> createRecommendationLoc(String name) {
        return locatedRepository.createRecommendationloc(name);
    }
}
