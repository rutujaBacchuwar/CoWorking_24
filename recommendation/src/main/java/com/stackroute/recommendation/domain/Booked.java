package com.stackroute.recommendation.domain;


import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity("Booked")
public class Booked {

    @GraphId
    private long id;

    @StartNode
    private User user;
    @EndNode
    private Category category;

}
