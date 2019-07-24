package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.Location;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface LocationRepository extends Neo4jRepository<Location,Long> {

    @Query("MATCH (n:Location) WHERE n.locationName={locationName} RETURN n")
    public Location getNode(@Param("locationName") String locationName);

    @Query("MATCH (n:Location) RETURN n")
    public Collection<Location> getAll();

    @Query("CREATE (u:Location) SET u.locationId={locationId},u.locationName={locationName},u.latitude={latitude},u.longitude={longitude}")
    public Location createNode(long locationId, String locationName, double latitude, double longitude);

    @Query("MATCH (n:Location) WHERE n.locationId={locationId} DETACH DELETE n RETURN 'node deleted' ")
    public Location deleteNode(long locationId);

    @Query("MATCH (l:Location) DETACH DELETE l")
    public Location deleteAllNodes();

    @Query("MATCH (n:Location) WHERE n.locationId={locationId} SET n.locationName={locationName} RETURN n")
    public Location updateNode(long locationId, String locationName);

    @Query("MATCH (n:Location) WHERE n.locationName={locationName} RETURN n")
    public Location existByName(String locationName);

}
