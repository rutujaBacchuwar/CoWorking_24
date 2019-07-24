package com.stackroute.kafka.domain;

import com.stackroute.workspaceService.domain.*;
import com.stackroute.workspaceService.service.CategoryService;
import com.stackroute.workspaceService.service.LocationService;
import com.stackroute.workspaceService.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
    MySpace myspace = new MySpace();
    MyAddress myaddress = new MyAddress();
    MyCategory myCategory3 = new MyCategory();
    MyCategory myCategory1 = new MyCategory();
    MyCategory myCategory2 = new MyCategory();
    MyCategory myCategory=new MyCategory();
    MyLocation myLocation=new MyLocation();
    MyDimension myDimension = new MyDimension();
    Category category = new Category();
    @Autowired
    private SpaceService spaceService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private LocationService locationService;



    @KafkaListener(topics = "spaceTopic")
    public void receive(@Payload Space space){

        try{
            List<Category> list = new ArrayList<Category>();
            list = space.getCategory();


            for (int i=0; i<list.size();i++) {
                Category category = list.get(i);

                myCategory.setCategoryId(category.getCategoryId());
                myCategory.setCategoryName(category.getCategoryName());
                myCategory.setPrice(category.getMonthlyPrice());
               // myCategory.setPrice(category.getMonthlyPrice());
                myCategory.setAdditionalAmenities(category.getAdditionalAmenities());
                myCategory.setMySpace(myspace);
                myCategory.setMyAddress(myaddress);
                myCategory.setLocation(myLocation);
                categoryService.saveCategory(myCategory);

                // for space
                myspace.setSpaceId(space.getSpaceId());
                myspace.setSpaceName(space.getSpaceName());
                myspace.setSpaceImageUrl(space.getSpaceImageUrl());
                myspace.setTotalprice(space.getTotalprice());
                spaceService.saveSpace(myspace);
                System.out.println(myspace.toString());

                // for address
                Address address = space.getAddress();
                myaddress.setArea(address.getArea());
                myaddress.setBuildingNumber(address.getBuildingNumber());
                myaddress.setCity(address.getCity());
                myaddress.setCountry(address.getCountry());
                myaddress.setPincode(address.getPincode());
                myaddress.setState(address.getState());
                myCategory.setMyAddress(myaddress);
                categoryService.updateCategory(myCategory);
                System.out.println(myCategory.toString());


                //for location
                Location location = space.getLocation();
                myLocation.setLocationId(location.getLocationId());
                myLocation.setLatitude(location.getLatitude());
                myLocation.setLongitude(location.getLongitude());
                myLocation.setLocationName(location.getLocationName());
                myCategory.setLocation(myLocation);
                categoryService.updateCategory(myCategory);
                System.out.println(myCategory.toString());



                Dimension dimension = category.getDimension();
                myDimension.setHeight(dimension.getHeight());
                myDimension.setWidth(dimension.getWidth());
                myCategory.setMyDimension(myDimension);
                categoryService.updateCategory(myCategory);
                System.out.println(myCategory.toString());

            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(space.toString());
    }



    @KafkaListener(topics = "spaceTopicLocation")
    public void receiveforlocation(@Payload Space space) {

        System.out.println("Consumed space"+space.toString());
        System.out.println("Initial location"+myLocation.toString());
        Location l1 = space.getLocation();
        System.out.println("consumed location"+l1.toString());

        try {


            myLocation.setLocationId(l1.getLocationId());
            myLocation.setLocationName(l1.getLocationName());
            myLocation.setLongitude(l1.getLongitude());
            myLocation.setLatitude(l1.getLatitude());
            locationService.saveLocation(myLocation);
            System.out.println("first location"+myLocation.toString());

            // for address of location
            Address a1 = space.getAddress();
            MyAddress ma1 = new MyAddress();
            ma1.setArea(a1.getArea());
            ma1.setState(a1.getState());
            ma1.setPincode(a1.getPincode());
            ma1.setCountry(a1.getCountry());
            ma1.setCity(a1.getCity());
            ma1.setBuildingNumber(a1.getBuildingNumber());
            myLocation.setAddress(ma1);
            locationService.updateLocation(myLocation);
            System.out.println("second location"+myLocation.toString());


            // for space of location
            Space s2 = new Space();
            MySpace ms = new MySpace();
            ms.setSpaceId(space.getSpaceId());
            ms.setSpaceName(space.getSpaceName());
            ms.setSpaceImageUrl(space.getSpaceImageUrl());
            ms.setTotalprice(space.getTotalprice());
            myLocation.setMySpace(ms);
            locationService.updateLocation(myLocation);
            System.out.println(myLocation.toString());
            // }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(space.toString());

    }

    @KafkaListener(topics = "spaceTopicCategory")
    public void receiveForCategory(@Payload Space space) {
        MyLocation myLocation = new MyLocation();
        List<Category> categories = space.getCategory();
        Location location = space.getLocation();

        myLocation.setLocationId(location.getLocationId());
        myLocation.setLatitude(location.getLatitude());
        myLocation.setLongitude(location.getLongitude());
        myLocation.setLocationName(location.getLocationName());
        myLocation.setMycategory(categories);

        locationService.saveLocation(myLocation);


    }

}


