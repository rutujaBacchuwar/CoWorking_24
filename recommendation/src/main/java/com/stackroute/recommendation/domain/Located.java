package com.stackroute.recommendation.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity("Located")
public class Located {

    @GraphId
    private long id;

    @StartNode
    private Space space;
    @EndNode
    private Location location;

}
