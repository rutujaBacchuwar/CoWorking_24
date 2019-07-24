package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.Category;
import com.stackroute.recommendation.domain.Space;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.ArrayList;
import java.util.Collection;

public interface LocatedRepository extends Neo4jRepository<Space,Long> {
    @Query("MATCH (u:Space)-[r:Located]->(m:Location) RETURN u,r,m")
    public Collection<Space> getRelationship();

    @Query("MATCH (a:Space),(b:Location) WHERE a.spaceName = {spaceName} AND b.locationName = {locationName} CREATE (a)-[r:Located]->(b) RETURN r")
    public Space createRelationship(String spaceName, String locationName);

    @Query("MATCH (a:Category),(b:Location) WHERE a.categoryName = {categoryName} AND b.locationName = {locationName} CREATE (a)-[r:Located]->(b) RETURN r")
    public Category createRelationshipLoc(String categoryName, String locationName);

    @Query( "MATCH (Category)-[r:Located]->(Location) DELETE r;")
    public Category deleteRelationshipcat();

    @Query( "MATCH (Space)-[r:Located]->(Location) DELETE r;")
    public Space deleteRelationship();

    @Query("MATCH (User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) RETURN c.categoryName")
    public ArrayList<String> getCategoryName();

    @Query("MATCH (c:Category)<-[:Contains]-(m:Space) RETURN c.categoryName")
    public ArrayList<String> getAllCategoryName();

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)-[:Contains]-(m:Space)-[:Located]->(n:Location)<-[:Located]-(s:Space)-[contains]-(l:Category) WHERE u.name={name} and c.categoryName=l.categoryName and s.spaceId<>c.space RETURN s,l")
    public Collection<Space> createRecommendationloc(String name);

}
