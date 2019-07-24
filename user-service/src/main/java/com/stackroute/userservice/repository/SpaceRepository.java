package com.stackroute.userservice.repository;

import com.stackroute.kafka.domain.Space;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SpaceRepository extends MongoRepository<Space,Integer> {

    //@Query("db.space.find( { name: 'User' } )")
  //  public Space findByName(String name);

    @Query("{ 'user.name': '?0' }")
    List<Space> findByName(String name);

    @Query("{'spaceName': '?0'}")
    Space findBySpaceName(String spaceName);

}