package com.statementlabs.parking_api.infrastructure.config;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.domain.ParkingSpot;
import com.statementlabs.parking_api.domain.SpotStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(ParkingSpotRepository repository) {
        return args -> {

            long count = repository.count();

            if (count >= 50) {
                System.out.println(">>> Vagas já inicializadas.");
                return;
            }

            System.out.println(">>> Inicializando vagas...");

            for (long i = count + 1; i <= 50; i++) {

                repository.save(new ParkingSpot(i, SpotStatus.FREE));
            }

            System.out.println(">>> Vagas prontas.");
        };
    }
}
