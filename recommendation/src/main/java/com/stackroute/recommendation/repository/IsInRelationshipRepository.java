package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.IsIn;
import com.stackroute.recommendation.domain.Space;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface IsInRelationshipRepository extends Neo4jRepository<IsIn,Long> {

    @Query("MATCH (u:Location)-[r:IsIn]->(m:City) RETURN u")
    public Collection<IsIn> getRelationship();

    @Query("MATCH (a:Location),(b:City) WHERE a.locationName = {locationName} AND b.cityName = {cityName} CREATE (a)-[r:IsIn]->(b) RETURN r")
    public IsIn createRelationship(String locationName, String cityName);

//    @Query("MATCH (s:Space)-[:Located]->(l:Location)-[:IsIn]->(c:City) RETURN s")
//    public Collection<Space> getSpaceCity();

    @Query("MATCH (s:Space)-[:Located]->(l:Location)-[:IsIn]->(c:City) where c.cityName={cityName} RETURN s")
    public Collection<Space> getSpaceCity(String cityName);


}
