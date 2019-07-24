package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.Category;
import com.stackroute.recommendation.domain.Space;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface LocatedService {

    public Collection<Space> getRelationship();
    public Space createRelationship(String spaceName, String locationName);
    public Category createRelationshipLoc(String categoryName, String locationName);
    public Category deleteRelationshipcat();
    public Space deleteRelationship();
    public Collection<Space> createRecommendationLoc(String name);

}
