package com.github.myfreeit.meteoapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurements")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Temperature value must not be null")
    @Min(value = -100, message = "Temperature must be greater or equal to -100°C")
    @Max(value = 100, message = "Temperature must be less or equal to 100°C")
    @Column(name = "value", nullable = false)
    private Double value;

    @NotNull(message = "Raining flag must not be null")
    @Column(name = "raining", nullable = false)
    private Boolean raining;

    @NotNull(message = "Sensor reference must not be null")
    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    @CreatedDate
    @Column(name = "measurement_date_time", nullable = false, updatable = false)
    private LocalDateTime measurementDateTime;
}
