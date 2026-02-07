package com.statementlabs.parking_api.infrastructure.adapter;

import com.statementlabs.parking_api.application.port.ParkingSpotRepository;
import com.statementlabs.parking_api.domain.ParkingSpot;
import com.statementlabs.parking_api.domain.SpotStatus;
import com.statementlabs.parking_api.infrastructure.repository.JpaParkingSpotRepository;
import com.statementlabs.parking_api.infrastructure.mapper.ParkingSpotMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ParkingSpotRepositoryAdapter implements ParkingSpotRepository {

    private final JpaParkingSpotRepository jpaRepository;

    public ParkingSpotRepositoryAdapter(JpaParkingSpotRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<ParkingSpot> findAll() {
        return jpaRepository.findAll().stream()
                .map(ParkingSpotMapper::toDomain)
                .toList();
    }

    @Override
    public List<ParkingSpot> findAvailable() {
        return jpaRepository.findByStatus(SpotStatus.FREE).stream()
                .map(ParkingSpotMapper::toDomain)
                .toList();
    }

    @Override
    public void save(ParkingSpot spot) {
        jpaRepository.save(ParkingSpotMapper.toEntity(spot));
    }

    @Override
    public Optional<ParkingSpot> findById(Long id) {
        return jpaRepository.findById(id)
                .map(ParkingSpotMapper::toDomain);
    }

    @Override
    public Optional<ParkingSpot> findFirstFree() {
        return jpaRepository.findByStatus(SpotStatus.FREE)
                            .stream()
                            .findFirst()
                            .map(ParkingSpotMapper::toDomain);
    }

    @Override
    public long count() {
        return jpaRepository.count();
    }
}