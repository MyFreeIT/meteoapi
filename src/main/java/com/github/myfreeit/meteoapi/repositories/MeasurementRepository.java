package com.github.myfreeit.meteoapi.repositories;

import com.github.myfreeit.meteoapi.entities.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
