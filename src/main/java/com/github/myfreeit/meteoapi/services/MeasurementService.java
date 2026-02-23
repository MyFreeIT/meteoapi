package com.github.myfreeit.meteoapi.services;

import com.github.myfreeit.meteoapi.dto.MeasurementDto;
import com.github.myfreeit.meteoapi.dto.MeasurementsResponse;
import com.github.myfreeit.meteoapi.entities.Measurement;
import com.github.myfreeit.meteoapi.entities.Sensor;
import com.github.myfreeit.meteoapi.mappers.MeasurementMapper;
import com.github.myfreeit.meteoapi.repositories.MeasurementRepository;
import com.github.myfreeit.meteoapi.repositories.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;
    private final MeasurementMapper measurementMapper;

    @Transactional
    public MeasurementDto save(MeasurementDto dto) {

        Measurement measurement = measurementMapper.toEntity(dto);
        Sensor sensor = getSensorByName(dto.sensorDto().name());
        measurement.setSensor(sensor);

        return measurementMapper.toDto(measurementRepository.save(measurement));
    }

    public MeasurementsResponse findAll() {

        return new MeasurementsResponse(measurementRepository.findAll().stream()
                .map(measurementMapper::toDto)
                .toList());
    }

    public long countsRainyDays() {

        return measurementRepository.countByRainingTrue();
    }

    private Sensor getSensorByName(String name) {
        return sensorRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Sensor with name '%s' not found".formatted(name)));
    }
}
