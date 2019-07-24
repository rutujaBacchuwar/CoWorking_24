package com.stackroute.recommendation.domain;


import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity("Contains")
public class Contains {

    @GraphId
    private long id;

    @StartNode
    private Space space;
    @EndNode
    private Category category;
}
