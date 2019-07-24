package com.stackroute.userservice.service;

import com.stackroute.kafka.domain.Space;
import com.stackroute.kafka.domain.User;
import com.stackroute.userservice.exception.SpaceAlreadyExistException;
import com.stackroute.userservice.exception.SpaceNotFound;

import java.util.List;

public interface SpaceService {

    public Space saveSpace(Space space) throws SpaceAlreadyExistException;
    public List<Space> getAllSpaces() ;
    public Space update(Space space) throws SpaceNotFound;
    public List<Space> deleteSpace(int spaceId) throws SpaceNotFound;
    public List<Space> findByName(String name);
    public Space findBySpaceName(String spaceName);
}
