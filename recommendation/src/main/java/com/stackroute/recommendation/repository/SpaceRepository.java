package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.Space;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SpaceRepository extends Neo4jRepository<Space,Long> {

    @Query("MATCH (n:Space) RETURN n")
    public Collection<Space> getAll();

    @Query("CREATE (u:Space) SET u.spaceId={spaceId},u.spaceName={spaceName},u.spaceImageUrl={spaceImageUrl}")
    public Space createNode(long spaceId, String spaceName,String spaceImageUrl);

    @Query("MATCH (s:Space)-[:Located]-(l:Location) WHERE l.locationName={locationName} RETURN s")
    public Collection<Space> getByLocation(String locationName);


    @Query("MATCH (n:Category)-[:Contains]-(s:Space) WHERE s.spaceName=n.space RETURN n.categoryName")
    public Collection<String> getAllCategory();


    @Query("MATCH (n:Space) WHERE n.spaceName={spaceName} RETURN n")
    public Space getNode(@Param("spaceName") String spaceName);

    @Query("MATCH (n:Space) WHERE n.spaceId={spaceId} DETACH DELETE n RETURN 'node deleted' ")
    public Space deleteNode(long spaceId);

    @Query("MATCH (Space) DETACH DELETE Space")
    public Space deleteAllNodes();

    @Query("MATCH (n:Space) WHERE n.spaceId={spaceId} SET n.spaceName={spaceName} RETURN n")
    public Space updateNode(long spaceId, String spaceName);




}
