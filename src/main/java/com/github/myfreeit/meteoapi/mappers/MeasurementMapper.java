package com.github.myfreeit.meteoapi.mappers;

import com.github.myfreeit.meteoapi.dto.MeasurementDto;
import com.github.myfreeit.meteoapi.entities.Measurement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeasurementMapper {
    @Mapping(source = "sensor", target = "sensorDto")
    MeasurementDto toDto(Measurement measurement);
    @Mapping(source = "sensorDto", target = "sensor")
    Measurement toEntity(MeasurementDto measurementDto);
}
