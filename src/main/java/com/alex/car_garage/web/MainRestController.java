package com.alex.car_garage.web;

import com.alex.car_garage.model.Car;
import com.alex.car_garage.model.CarForm;
import com.alex.car_garage.repo.CarRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainRestController {
    private CarRepo carRepo;

    @RequestMapping(value = "/cars",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Car> getCars() {
        return (List<Car>) carRepo.findAll();
    }

    @RequestMapping(value = "/car/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Car getCar(@PathVariable("id") Long id) {
        if (!carRepo.findById(id).isPresent()) return null;
        return carRepo.findById(id).get();
    }

    @RequestMapping(value = "/car",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Car addCar(@RequestBody CarForm carForm) {
        return carRepo.save(new Car(carForm));
    }

    @RequestMapping(value = "/car/{id}",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Car updateCar(@RequestBody CarForm carForm, @PathVariable("id") Long id) {
        if (!carRepo.findById(id).isPresent()) return null;
        Car car = carRepo.findById(id).get();
        car.setColor(Car.Color.valueOf(carForm.getColor()));
        car.setModel(carForm.getModel());
        return carRepo.save(car);
    }

    @RequestMapping(value = "/car{id}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteCar(@PathVariable("id") Long id) {
        carRepo.deleteById(id);
    }

}
