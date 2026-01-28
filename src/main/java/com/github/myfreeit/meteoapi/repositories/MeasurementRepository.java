package com.github.myfreeit.meteoapi.repositories;

import com.github.myfreeit.meteoapi.entities.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    long countByRainingTrue();
    Optional<Measurement> findBySensorName(String name);
}
