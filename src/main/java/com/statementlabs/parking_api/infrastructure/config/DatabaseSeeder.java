package com.parking_api.infrastructure.config;

import com.parking_api.application.port.ParkingSpotRepository;
import com.parking_api.domain.model.ParkingSpot;
import com.parking_api.domain.model.SpotStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseSeeder {


    @Bean
    CommandLineRunner initDatabase(ParkingSpotRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                System.out.println(">>> Banco de dados vazio. Inicializando 50 vagas...");

                for (long i = 1; i <= 50; i++) {
                    ParkingSpot spot = new ParkingSpot(i, SpotStatus.FREE);
                    
                    repository.save(spot);
                }

                System.out.println(">>> Sucesso! 50 vagas criadas e prontas para uso.");
            } else {
                System.out.println(">>> A base de dados já contém vagas. Inicialização pulada.");
            }
        };
    }
}