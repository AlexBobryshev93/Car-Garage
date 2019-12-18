package com.alex.car_garage;

import com.alex.car_garage.model.Car;
import com.alex.car_garage.repo.CarRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarGarageApplication {
    @Bean
    CommandLineRunner dataLoader(CarRepo carRepo) {
        return args -> {
            carRepo.save(new Car("Toyota", "WHITE"));
            carRepo.save(new Car("Ferrari", "YELLOW"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CarGarageApplication.class, args);
    }

}
