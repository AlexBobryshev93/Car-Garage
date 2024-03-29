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

    public Car(String model, String color) {
        this.model = model;

        try {
            this.color = Color.valueOf(color);
        } catch (IllegalArgumentException e) {
            this.color = Color.OTHER;
        }
    }

    public Car(CarForm carForm) {
        this(carForm.getModel(), carForm.getColor());
    }

    public enum Color {
        BLACK, WHITE, RED, GREEN, SILVER, YELLOW, BLUE, BROWN, PURPLE, PINK, ORANGE, OTHER
    }
}
