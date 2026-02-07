package com.parking_api.infrastructure.config;

import com.parking_api.application.port.ParkingSpotRepository;
import com.parking_api.domain.ParkingSpot;
import com.parking_api.domain.SpotStatus;
import com.parking_api.infrastructure.persistence.entity.ParkingSpotEntity;
import com.parking_api.infrastructure.persistence.mapper.ParkingSpotMapper;
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

                ParkingSpot spotDomain = new ParkingSpot(i, SpotStatus.FREE);

                ParkingSpotEntity entity = PersistenceParkingSpotMapper.toEntity(spotDomain);

                repository.save(entity);
            }

            System.out.println(">>> Vagas prontas.");
        };
    }
}
