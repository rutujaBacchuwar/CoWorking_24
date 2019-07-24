package com.stackroute.workspaceService.service;

import com.stackroute.workspaceService.exception.LocationAlreadyExists;
import com.stackroute.workspaceService.exception.LocationNotFoundException;
import com.stackroute.workspaceService.domain.MyLocation;

import java.util.List;
public interface LocationService {
    List<MyLocation> getLocation();

    MyLocation saveLocation(MyLocation location) /*throws LocationAlreadyExists*/;

    boolean deleteLocation(MyLocation location) throws Exception;

    MyLocation updateLocation(MyLocation location) throws LocationNotFoundException;
    public List<MyLocation> findByLocation(String locationName);
}


