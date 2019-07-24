package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.City;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface CityRepository extends Neo4jRepository<City,Long> {

    @Query("MATCH (n:City) RETURN n")
    public Collection<City> getAll();

    @Query("CREATE (u:City) SET u.cityName={cityName}")
    public City createNode(String cityName);

    @Query("MATCH (n:City) WHERE n.cityName={cityName} RETURN n")
    public City existByName(String cityName);
}
