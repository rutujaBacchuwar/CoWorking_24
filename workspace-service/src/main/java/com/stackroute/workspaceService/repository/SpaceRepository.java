package com.stackroute.workspaceService.repository;

import com.stackroute.workspaceService.domain.MySpace;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpaceRepository extends MongoRepository<MySpace,Integer> {

    MySpace findBySpaceName(String spaceName);

}
