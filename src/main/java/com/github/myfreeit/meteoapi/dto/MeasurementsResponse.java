package com.github.myfreeit.meteoapi.dto;

import java.util.List;

public record MeasurementsResponse(List<MeasurementDto> measurements) {
}
