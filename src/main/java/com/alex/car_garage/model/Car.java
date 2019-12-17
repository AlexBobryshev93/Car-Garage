package com.alex.car_garage.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private Color color;

    public Car(String model, Color color) {
        this.model = model;
        this.color = color;
    }

    public Car(String model, String color) {
        this.model = model;
        this.color = Color.valueOf(color);
    }

    public Car(CarForm carForm) {
        this.model = carForm.getModel();
        this.color = Color.valueOf(carForm.getColor());
    }

    public enum Color {
        BLACK, WHITE, RED, GREEN, SILVER, YELLOW, BLUE, BROWN, PURPLE, PINK
    }
}
