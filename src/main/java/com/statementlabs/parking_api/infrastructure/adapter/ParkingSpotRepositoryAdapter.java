package com.statementlabs.parking_api.infrastructure.adapter;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.domain.ParkingSpot;
import com.statementlabs.parking_api.domain.SpotStatus;
import com.statementlabs.parking_api.infrastructure.repository.JpaParkingSpotRepository;
import com.statementlabs.parking_api.infrastructure.mapper.ParkingSpotMapper;
import com.statementlabs.parking_api.infrastructure.persistence.entity.ParkingSpotEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ParkingSpotRepositoryAdapter implements ParkingSpotRepository {

    private final JpaParkingSpotRepository jpaRepository;
    private final ParkingSpotMapper mapper;

    public ParkingSpotRepositoryAdapter(JpaParkingSpotRepository jpaRepository, ParkingSpotMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<ParkingSpot> findFirstFree() {
        return jpaRepository.findFirstByStatus(SpotStatus.FREE.name())
                .map(mapper::toDomain);
    }

    @Override
    public Optional<ParkingSpot> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public ParkingSpot save(ParkingSpot spot) {

        jpaRepository.updateStatus(spot.getId(), spot.getStatus().name());
        
        return spot;
    }

    @Override
    public List<ParkingSpot> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    public List<ParkingSpot> findByStatus(SpotStatus status) {
        return jpaRepository.findAllByStatus(status.name()).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}