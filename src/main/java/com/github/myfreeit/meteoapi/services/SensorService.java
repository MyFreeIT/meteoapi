package com.github.myfreeit.meteoapi.services;

import com.github.myfreeit.meteoapi.dto.SensorDto;
import com.github.myfreeit.meteoapi.entities.Sensor;
import com.github.myfreeit.meteoapi.mappers.SensorMapper;
import com.github.myfreeit.meteoapi.repositories.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    @Transactional
    public SensorDto save(SensorDto dto) {
        if (sensorRepository.existsByName(dto.name())) {
            throw new IllegalArgumentException("Sensor with name '%s' already exists".formatted(dto.name()));
        }
        Sensor sensor = sensorMapper.toEntity(dto);
        return sensorMapper.toDto(sensorRepository.save(sensor));
    }
}
