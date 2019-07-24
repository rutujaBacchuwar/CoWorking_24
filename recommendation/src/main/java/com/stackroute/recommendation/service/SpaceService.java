package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.Space;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface SpaceService {

    public Space findByName(String spaceName);
    public Collection<Space> getAll();
    public Space create(long spaceId, String spaceName,String spaceImageUrl);
    public Space delete(Long spaceId);
    public Space deleteAll();
    public Space update(long spaceId, String spaceName);
    public Collection<String> getAllCategory();
    public Collection<Space> getSpace(String locationName);

}
