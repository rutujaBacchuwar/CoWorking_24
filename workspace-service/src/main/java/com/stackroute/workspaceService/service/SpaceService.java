package com.stackroute.workspaceService.service;
import com.stackroute.workspaceService.domain.MySpace;


public interface SpaceService {
    public MySpace saveSpace(MySpace myspace);
    public MySpace findBySpaceName(String spaceName);

}
