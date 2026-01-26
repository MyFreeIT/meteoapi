package com.github.myfreeit.meteoapi.mappers;

import com.github.myfreeit.meteoapi.dto.MeasurementDto;
import com.github.myfreeit.meteoapi.entities.Measurement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeasurementMapper {
    MeasurementDto toDto(Measurement measurement);
    Measurement toEntity(MeasurementDto measurementDto);
}
