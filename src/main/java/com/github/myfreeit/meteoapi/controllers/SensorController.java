package com.github.myfreeit.meteoapi.controllers;

import com.github.myfreeit.meteoapi.dto.SensorDto;
import com.github.myfreeit.meteoapi.services.SensorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @PostMapping("/registration")
    public ResponseEntity<SensorDto> register(@Valid @RequestBody SensorDto dto) {
        SensorDto saved = sensorService.save(dto);
        return ResponseEntity.ok(saved);
    }
}
