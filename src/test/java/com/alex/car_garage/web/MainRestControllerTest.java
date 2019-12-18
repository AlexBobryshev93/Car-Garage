package com.alex.car_garage.web;

import com.alex.car_garage.model.Car;
import com.alex.car_garage.model.CarForm;
import com.alex.car_garage.repo.CarRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarRepo carRepo;

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = carRepo.save(new Car("Toyota", "BLACK"));
    }

    @After
    public void tearDown() throws Exception {
        carRepo.deleteAll();
        car = null;
    }

    @Test
    public void testGetCars() throws Exception {
        mockMvc.perform(get("/cars"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCar() throws Exception {
        mockMvc.perform(get("/car/" + car.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAddCar() throws Exception {
        mockMvc.perform(post("/car")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new CarForm("BMW", "SILVER"))))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateCar() throws Exception {
        mockMvc.perform(put("/car/" + car.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new CarForm("BMW", "SILVER"))))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCar() throws Exception {
        mockMvc.perform(delete("/car/" + car.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}