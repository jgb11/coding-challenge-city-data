package org.jgb.citydata;

import org.jgb.citydata.model.CityInfo;
import org.jgb.citydata.repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;

/**
 * @author jgb
 * @since 11/02/19 17:11
 */
@SpringBootApplication
public class CityDataApplication implements CommandLineRunner {

    @Autowired
    private CitiesRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(CityDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Initialize mock data
        repository.deleteAll();

        repository.save(new CityInfo("Zaragoza", "Sevilla", LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00")));
        repository.save(new CityInfo("Zaragoza", "Madrid", LocalTime.parse("10:00:00"), LocalTime.parse("11:20:00")));
        repository.save(new CityInfo("Madrid", "Barcelona", LocalTime.parse("13:20:00"), LocalTime.parse("19:40:00")));
        repository.save(new CityInfo("Madrid", "Sevilla", LocalTime.parse("11:30:00"), LocalTime.parse("13:30:00")));
        repository.save(new CityInfo("Zaragoza", "Valencia", LocalTime.parse("07:00:00"), LocalTime.parse("07:10:00")));
        repository.save(new CityInfo("Valencia", "Madrid", LocalTime.parse("07:15:00"), LocalTime.parse("07:30:00")));
        repository.save(new CityInfo("Madrid", "Sevilla", LocalTime.parse("07:40:00"), LocalTime.parse("07:50:00")));

//        System.out.println("CityInfo List found with findAll():");
//        System.out.println("-------------------------------");
//        for (CityInfo cityInfo : repository.findAll()) {
//            System.out.println(cityInfo);
//        }
//        System.out.println();
//
//        System.out.println("CityInfo List found with findByCity('Zaragoza')");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByCity("Zaragoza"));
    }
}
