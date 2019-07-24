package com.stackroute.recommendation.service;

import com.stackroute.recommendation.domain.Space;
import com.stackroute.recommendation.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SpaceServiceImpl implements SpaceService {

    SpaceRepository spaceRepository;

    @Autowired
    public SpaceServiceImpl(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    @Override
    public Space findByName(String spaceName) {
        return spaceRepository.getNode(spaceName);
    }

    @Override
    public Collection<Space> getAll() {
        return spaceRepository.getAll();
    }

    @Override
    public Space create(long spaceId, String spaceName,String spaceImageUrl) {
        return spaceRepository.createNode(spaceId,spaceName,spaceImageUrl);
    }

    @Override
    public Space delete(Long spaceId) {
        return spaceRepository.deleteNode(spaceId);
    }

    @Override
    public Space deleteAll() {
        return spaceRepository.deleteAllNodes();
    }

    @Override
    public Space update(long spaceId, String spaceName) {
        return spaceRepository.updateNode(spaceId,spaceName);
    }

    @Override
    public Collection<String> getAllCategory() {
        return spaceRepository.getAllCategory();
    }

    @Override
    public Collection<Space> getSpace(String locationName) {
        return spaceRepository.getByLocation(locationName);
    }
}
