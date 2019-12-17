package com.alex.car_garage.repo;

import com.alex.car_garage.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepo extends CrudRepository<Car, Long> {
}
