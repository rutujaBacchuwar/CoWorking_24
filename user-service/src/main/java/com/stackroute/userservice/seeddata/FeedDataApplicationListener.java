package com.stackroute.userservice.seeddata;

import com.opencsv.CSVReaderBuilder;
import com.stackroute.kafka.domain.*;
import com.stackroute.userservice.exception.SpaceAlreadyExistException;
import com.stackroute.userservice.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;

@Component
public class FeedDataApplicationListener implements ApplicationListener <ContextRefreshedEvent> {

    @Autowired
    private SpaceService spaceService;
    private Space space=new Space();



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {

        File file = new File("./assets/SpaceData.csv");
        System.out.println("File Exists ======================================: " + file.exists());

        try {
            FileReader filereader = new FileReader(file);

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            System.out.println("ohsad" + allData.size());

            Address address = new Address();
            Category category = new Category();
            Location location = new Location();
            User user =new User();
            Amenities amenities =new Amenities();


            for (String[] row : allData) {


                user.setName(row[0]);

                space.setUser(user);

                space.setSpaceId(Integer.parseInt(row[1]));
                space.setSpaceName(row[2]);
                space.setSpaceImageUrl(row[3]);

                address.setBuildingNumber(row[4]);
                address.setArea(row[5]);
                address.setCity(row[6]);
                address.setState(row[7]);
                address.setCountry(row[8]);
                address.setPincode(Integer.parseInt(row[9]));

                space.setAddress(address);

                amenities.setAmenities(row[10].split(","));

                space.setAmenities(amenities);

                location.setLocationName(row[11]);
                location.setLatitude(Double.parseDouble(row[12]));
                location.setLongitude(Double.parseDouble(row[13]));

                space.setLocation(location);

                List<Category> categories =new ArrayList<Category>();

                category.setCategoryId(Integer.parseInt(row[14]));
                category.setCategoryName(row[15]);
                category.setHourlyPrice(Double.parseDouble(row[16]));
                category.setDailyPrice(Double.parseDouble(row[17]));
                category.setMonthlyPrice(Double.parseDouble(row[18]));
                category.setCapacity(Integer.parseInt(row[19]));
                category.setAdditionalAmenities(row[20].split(","));
                categories.add(category);
                space.setCategory(categories);


                spaceService.saveSpace(space);

                System.out.println("data got printed automatically");
                System.out.println("================================================================"+spaceService.getAllSpaces().size());

            }
        }

        catch (IOException ex)
        {
            ex.getMessage();
        }
        catch (SpaceAlreadyExistException ex)
        {
            ex.getMessage();
        }
    }


}
