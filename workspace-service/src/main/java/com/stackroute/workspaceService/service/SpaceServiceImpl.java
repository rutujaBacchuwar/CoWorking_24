package com.stackroute.workspaceService.service;


import com.stackroute.workspaceService.domain.MySpace;
import com.stackroute.workspaceService.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceServiceImpl implements SpaceService {
    SpaceRepository spaceRepository;
    MySpace mySpace=new MySpace();

    @Autowired
    public SpaceServiceImpl(SpaceRepository spaceRepository)
    {

        this.spaceRepository = spaceRepository;
    }

    @Override
    public MySpace saveSpace(MySpace myspace) {
        System.out.println(myspace.toString());
        return spaceRepository.save(myspace);
    }

    @Override
    public MySpace findBySpaceName(String spaceName)
    {
        return spaceRepository.findBySpaceName(spaceName);
    }



}
