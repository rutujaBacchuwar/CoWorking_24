package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.IsIn;
import com.stackroute.recommendation.domain.Space;

import java.util.Collection;

public interface IsInRelationshipService {

    public Collection<IsIn> getRelationship();
    public IsIn createrelationship(String locationName,String cityName);
    public Collection<Space> getSpaceWithCity(String cityName);
}
