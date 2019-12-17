package com.alex.car_garage.web;

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

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainRestControllerTest {
    @Autowired
    MainRestController controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetCars() throws Exception {
        mockMvc.perform(get("/cars"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCar() throws Exception {
        mockMvc.perform(get("/car/-1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAddCar() throws Exception {
        mockMvc.perform(post("/car")
                //.param("carForm", ))
                .contentType(MediaType.APPLICATION_JSON)
                .content("{model:'Toyota', color:'BLACK'}"))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().string(containsString("\"points\":11")));
    }

    @Test
    public void testUpdateCar() throws Exception {
    }

    @Test
    public void testDeleteCar() throws Exception {
    }
}