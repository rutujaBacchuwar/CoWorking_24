package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.Space;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ContainsService {

    public Collection<Space> getRelationship();
    public Space createRelationship(long spaceId);
    public Space createRelationshipAll();
    public Space deleteRelationship();
    public Collection<Space> recommendationprice(String name);
}
