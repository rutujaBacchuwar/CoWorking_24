package com.stackroute.workspaceService.repository;


import com.stackroute.workspaceService.domain.MyLocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface LocationRepository extends MongoRepository<MyLocation, Integer> {
    boolean existsByLocationId(int locationId);

    void deleteByLocationId(int locationId);

    @Query("{ 'locationName': '?0' }")
    List<MyLocation> findByLocationName(String locationName);

}

