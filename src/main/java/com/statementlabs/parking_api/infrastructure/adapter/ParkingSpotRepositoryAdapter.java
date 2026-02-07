package com.parking_api.infrastructure.persistence.adapter;

import com.parking_api.application.port.ParkingSpotRepository;
import com.parking_api.domain.model.ParkingSpot;
import com.parking_api.domain.model.SpotStatus;
import com.parking_api.infrastructure.persistence.jpa.JpaParkingSpotRepository;
import com.parking_api.infrastructure.persistence.mapper.PersistenceParkingSpotMapper;
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
                .map(PersistenceParkingSpotMapper::toDomain)
                .toList();
    }

    @Override
    public List<ParkingSpot> findAvailable() {
        return jpaRepository.findByStatus(SpotStatus.FREE).stream()
                .map(PersistenceParkingSpotMapper::toDomain)
                .toList();
    }

    @Override
    public void save(ParkingSpot spot) {
        jpaRepository.save(PersistenceParkingSpotMapper.toEntity(spot));
    }

    @Override
    public Optional<ParkingSpot> findById(Long id) {
        return jpaRepository.findById(id)
                .map(PersistenceParkingSpotMapper::toDomain);
    }

    @Override
    public long count() {
        return jpaRepository.count();
    }
}