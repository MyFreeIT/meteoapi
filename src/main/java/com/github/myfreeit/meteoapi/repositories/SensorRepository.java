package com.github.myfreeit.meteoapi.repositories;

import com.github.myfreeit.meteoapi.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
