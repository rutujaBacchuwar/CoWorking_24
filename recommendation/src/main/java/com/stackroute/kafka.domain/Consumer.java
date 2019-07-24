package com.stackroute.kafka.domain;

import com.stackroute.recommendation.domain.Location;
import com.stackroute.recommendation.exception.AlreadyExistException;
import com.stackroute.recommendation.repository.CityRepository;
import com.stackroute.recommendation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import java.util.ArrayList;
import java.util.List;


public class Consumer {
    com.stackroute.recommendation.domain.Location loc = new Location();
    com.stackroute.recommendation.domain.Space sp = new com.stackroute.recommendation.domain.Space();
    com.stackroute.recommendation.domain.Category cat = new com.stackroute.recommendation.domain.Category();
    com.stackroute.recommendation.domain.Booked booked=new com.stackroute.recommendation.domain.Booked();
    com.stackroute.recommendation.domain.City city=new com.stackroute.recommendation.domain.City();
    @Autowired
    private LocationService locationService;

    @Autowired
    private SpaceService spaceService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    LocatedService locatedService;

    @Autowired
    ContainsService containsService;

    @Autowired
    BookedService bookedService;

    @Autowired
    UserService userService;

   @Autowired
   CityService cityService;
    @Autowired
    IsInRelationshipService isInRelationshipService;

    @KafkaListener(topics = "spaceTopicForRecommendation")
    public void receive(@Payload Space space) {
        //  System.out.println("Consumed space for use of recommendation:" + space.toString());

        //for location
        com.stackroute.kafka.domain.Location location = space.getLocation();
        loc.setLocationName(location.getLocationName());
        loc.setLatitude(location.getLatitude());
        loc.setLongitude(location.getLongitude());
        loc.setLocationId((location.getLocationId()));
        try {
            locationService.create(loc.getLocationId(), loc.getLocationName(), loc.getLatitude(), loc.getLatitude());

        }
        catch (AlreadyExistException ex){
            ex.getMessage();

        }
        locatedService.createRelationship(space.getSpaceName(), space.getLocation().getLocationName());
        System.out.println("Saved data of location" + loc.toString());
        city.setCityName(space.getAddress().getCity());
        try {
            cityService.saveCity(city.getCityName());
        }
        catch (AlreadyExistException ex)
        {
            ex.getMessage();
        }

        isInRelationshipService.createrelationship(loc.getLocationName(),city.getCityName());
    }


    @KafkaListener(topics = "spaceTopicForRecommendation1")
    public void receive1(@Payload Space space) {

        //System.out.println("Consumed space for use of recommendation:" + space.toString());
        System.out.println("================================="+space.toString());
        spaceService.create(space.getSpaceId(),space.getSpaceName() ,space.getSpaceImageUrl());
        containsService.createRelationship(space.getSpaceId());

    }


    @KafkaListener(topics = "spaceTopicForRecommendationCategory")
    public void receive2(@Payload Space space) {
        //System.out.println("Consumed space for use of recommendation:" + space.toString());

        //for category
        List<Category> list = new ArrayList<Category>();
        list = space.getCategory();
        for (int i = 0; i < list.size(); i++) {
            Category category = list.get(i);
            cat.setCategoryId(category.getCategoryId());
            cat.setCategoryName(category.getCategoryName());
           // cat.setPrice(category.getPrice());
            System.out.println("ouweuewgeuwfuo"+category.getMonthlyPrice());
            cat.setPrice(category.getMonthlyPrice());
            System.out.println("consumed price"+cat.getPrice());
            sp.setSpaceId(space.getSpaceId());
            sp.setSpaceName(space.getSpaceName());
            sp.setSpaceImageUrl(space.getSpaceImageUrl());
            cat.setSpace(sp);

            categoryService.create(cat.getCategoryId(), cat.getCategoryName(), cat.getPrice(), cat.getSpace());
            System.out.println("Set values of category Id and category Name=" + cat.toString());

        }
    }


    @KafkaListener(topics = "BookingTopic1")
    public void receive3(@Payload Booking booking) {
        System.out.println("consumed booking"+booking.toString());
        MyUser myuser=booking.getMyUser();
        MySpace mySpace=myuser.getMyCategory().getMySpace();
        System.out.println("=================="+myuser.getName());
        System.out.println("++++++++++++++++++"+myuser.getMyCategory().getCategoryName());
        System.out.println("_______________________________"+mySpace.spaceId);
        userService.create(myuser.getUid(),myuser.getName(),myuser.getEmailId(),myuser.getUid());
        bookedService.createRelationship(myuser.getName(),myuser.getMyCategory().getCategoryName(),mySpace.spaceId);


    }

}


