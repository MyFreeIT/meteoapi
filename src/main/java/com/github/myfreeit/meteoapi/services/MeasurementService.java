package com.github.myfreeit.meteoapi.services;

import com.github.myfreeit.meteoapi.dto.MeasurementDto;
import com.github.myfreeit.meteoapi.entities.Measurement;
import com.github.myfreeit.meteoapi.mappers.MeasurementMapper;
import com.github.myfreeit.meteoapi.repositories.MeasurementRepository;
import com.github.myfreeit.meteoapi.repositories.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;
    private final MeasurementMapper measurementMapper;

    @Transactional
    public MeasurementDto save(MeasurementDto dto) {

        if(sensorRepository.existsByName(dto.sensorDto().name())) {
            throw new IllegalArgumentException("Sensor with name '%s' not found".formatted(dto.sensorDto().name()));
        }

        Measurement measurement = measurementMapper.toEntity(dto);

        return measurementMapper.toDto(measurementRepository.save(measurement));
    }

    public List<MeasurementDto> findAll() {

        return measurementRepository.findAll().stream()
                .map(measurementMapper::toDto)
                .toList();
    }

    public long countsRainyDays() {

        return measurementRepository.countByRainingTrue();
    }
}
