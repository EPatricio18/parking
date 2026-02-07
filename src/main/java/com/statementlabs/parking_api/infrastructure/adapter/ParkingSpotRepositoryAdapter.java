package com.statementlabs.parking_api.infrastructure.persistence.adapter;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.domain.*;
import com.statementlabs.parking_api.infrastructure.persistence.entity.ParkingSpotEntity;
import com.statementlabs.parking_api.infrastructure.persistence.repository.JpaParkingSpotRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ParkingSpotRepositoryAdapter implements ParkingSpotRepository {

    private final JpaParkingSpotRepository repository;

    public ParkingSpotRepositoryAdapter(JpaParkingSpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ParkingSpot> findFirstFree() {
        return repository.findFirstByStatus("FREE")
                .map(e -> new ParkingSpot(e.getId(), SpotStatus.valueOf(e.getStatus())));
    }

    @Override
    public Optional<ParkingSpot> findById(int id) {
        return repository.findById(id)
                .map(e -> new ParkingSpot(e.getId(), SpotStatus.valueOf(e.getStatus())));
    }

    @Override
    public void save(ParkingSpot spot) {
        repository.save(new ParkingSpotEntity(
                spot.getId(),
                spot.getStatus().name()
        ));
    }
}