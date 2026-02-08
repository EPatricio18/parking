package com.statementlabs.parking_api.infrastructure.config;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.application.port.TicketRepository;
import com.statementlabs.parking_api.application.usecase.*;
import com.statementlabs.parking_api.domain.TariffCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CheckInVehicleUseCase checkInVehicleUseCase(ParkingSpotRepository spotRepo, TicketRepository ticketRepo) {
        return new CheckInVehicleUseCase(spotRepo, ticketRepo);
    }

    @Bean
    public CheckOutVehicleUseCase checkOutVehicleUseCase(TicketRepository ticketRepo, ParkingSpotRepository spotRepo, TariffCalculator calculator) {
        return new CheckOutVehicleUseCase(ticketRepo, spotRepo, calculator);
    }

    @Bean
    public GetParkingStatusUseCase getParkingStatusUseCase(ParkingSpotRepository spotRepo) {
        return new GetParkingStatusUseCase(spotRepo);
    }

    @Bean
    public GetTicketHistoryUseCase getTicketHistoryUseCase(TicketRepository ticketRepo) {
        return new GetTicketHistoryUseCase(ticketRepo);
    }
}