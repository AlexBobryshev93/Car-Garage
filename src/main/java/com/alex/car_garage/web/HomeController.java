package com.alex.car_garage.web;

import com.alex.car_garage.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home() {
        return "home";
    }

    @ModelAttribute
    public void addColorsToModel(Model model) {
        List<Car.Color> list = Arrays.asList(Car.Color.values());
        model.addAttribute("colors", list);
    }
}
