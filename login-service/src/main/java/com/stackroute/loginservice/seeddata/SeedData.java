package com.stackroute.loginservice.seeddata;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.stackroute.kafka.domain.*;
import com.stackroute.loginservice.service.UserService;
import com.stackroute.loginservice.domain.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@Configuration
public class SeedData implements CommandLineRunner {

    UserService userService;

    @Autowired
    public SeedData(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        File file = new File("./assets/UserData.csv");
        System.out.println("File Exists : " + file.exists());

        try {
            FileReader filereader = new FileReader(file);

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();

            System.out.println("ohsad" + allData.size());

            User1 user = new User1();

            for (String[] row : allData) {

                System.out.println("values"+ Arrays.toString(row));

                user.setName(row[0]);
                user.setUid(Long.parseLong(row[1]));
                user.setPassword(row[2]);
                user.setRole(row[3]);

                System.out.println("running");
                userService.saveUser(user);

            }
        } catch (IOException ex) {
            ex.getMessage();

            System.out.println("Exception occured");
        }
    }
}


