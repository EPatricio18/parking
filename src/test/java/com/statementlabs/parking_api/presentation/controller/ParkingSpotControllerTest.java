package com.statementlabs.parking_api.presentation.controller;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.domain.ParkingSpot;
import com.statementlabs.parking_api.domain.SpotStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.context.ActiveProfiles;


@WebMvcTest(ParkingSpotController.class)
@ActiveProfiles("test")
class ParkingSpotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParkingSpotRepository repository;

    @Test
    void getAllSpots_returnsJson() throws Exception {
        when(repository.findAll()).thenReturn(List.of(new ParkingSpot(1L, SpotStatus.FREE)));

        mockMvc.perform(get("/api/spots"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }
}