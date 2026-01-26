package com.github.myfreeit.meteoapi.mappers;

import com.github.myfreeit.meteoapi.dto.SensorDto;
import com.github.myfreeit.meteoapi.entities.Sensor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface SensorMapper {
    SensorDto toDto(Sensor sensor);
    Sensor toEntity(SensorDto sensorDto);
}
