package com.stackroute.recommendation.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.StartNode;

public class IsIn {

    @GraphId
    private long id;

    @StartNode
    private Space space;
    @EndNode
    private City city;
}
