package com.github.myfreeit.meteoapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record MeasurementDto(

        @NotNull(message = "Temperature value must not be null")
        @Min(value = -100, message = "Temperature must be greater or equal to -100°C")
        @Max(value = 100, message = "Temperature must be less or equal to 100°C")
        Double value,

        @NotNull(message = "Raining flag must not be null")
        Boolean raining,

        SensorDto sensorDto
) {
}
