package org.jgb.citydata;

import org.jgb.citydata.model.CityInfo;
import org.jgb.citydata.repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author jgb
 * @since 11/02/19 17:11
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CitiesRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of citiInfos
        repository.save(new CityInfo("Zaragoza", "Madrid", LocalTime.parse("07:00:00"), LocalTime.parse("08:40:00")));
        repository.save(new CityInfo("Madrid", "Barcelona", LocalTime.parse("09:30:00"), LocalTime.parse("11:40:00")));
        repository.save(new CityInfo("Zaragoza", "Guadalajara", LocalTime.parse("10:00:00"), LocalTime.parse("11:20:00")));
        repository.save(new CityInfo("Guadalajara", "Madrid", LocalTime.parse("11:30:00"), LocalTime.parse("12:00:00")));
        repository.save(new CityInfo("Barcelona", "Madrid", LocalTime.parse("07:00:00"), LocalTime.parse("13:40:00")));

//        // fetch all customers
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (CityInfo customer : repository.findAll()) {
//            System.out.println(customer);
//        }
//        System.out.println();
//
//        // fetch an individual customer
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByCity("Zaragoza"));

    }
}
