package com.github.myfreeit.meteoapi.controllers;

import com.github.myfreeit.meteoapi.dto.MeasurementDto;
import com.github.myfreeit.meteoapi.services.MeasurementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;

    @PostMapping("/add")
    public ResponseEntity<MeasurementDto> add(@Valid @RequestBody MeasurementDto dto) {
        MeasurementDto saved = measurementService.save(dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<MeasurementDto>> getAll() {
        return ResponseEntity.ok(measurementService.findAll());
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Long> getRainyDaysCount() {
        return ResponseEntity.ok(measurementService.countsRainyDays());
    }
}
