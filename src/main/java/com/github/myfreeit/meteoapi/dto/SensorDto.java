package com.github.myfreeit.meteoapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SensorDto(
        @NotNull(message = "Sensor name must not be null")
        @Size(min = 3, max = 30, message = "Sensor name length must be between 3 and 30 characters")
        String name
) {
}
