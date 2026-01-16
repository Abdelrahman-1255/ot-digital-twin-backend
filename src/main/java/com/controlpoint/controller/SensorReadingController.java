package com.controlpoint.controller;

import com.controlpoint.model.SensorReading;
import com.controlpoint.service.SensorReadingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sensor-readings")
public class SensorReadingController {
    
    private final SensorReadingService sensorReadingService;
    
    public SensorReadingController(SensorReadingService sensorReadingService) {
        this.sensorReadingService = sensorReadingService;
    }
    
    @GetMapping
    public ResponseEntity<List<SensorReading>> getAllSensorReadings() {
        List<SensorReading> readings = sensorReadingService.getAllSensorReadings();
        return ResponseEntity.ok(readings);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SensorReading> getSensorReadingById(@PathVariable Long id) {
        return sensorReadingService.getSensorReadingById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/asset/{assetId}")
    public ResponseEntity<List<SensorReading>> getSensorReadingsByAssetId(@PathVariable Long assetId) {
        List<SensorReading> readings = sensorReadingService.getSensorReadingsByAssetId(assetId);
        return ResponseEntity.ok(readings);
    }
    
    @GetMapping("/asset/{assetId}/latest")
    public ResponseEntity<SensorReading> getLatestSensorReading(@PathVariable Long assetId) {
        return sensorReadingService.getLatestSensorReadingByAssetId(assetId)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<SensorReading> recordSensorReading(@RequestBody SensorReading sensorReading) {
        SensorReading recorded = sensorReadingService.recordSensorReading(sensorReading);
        return ResponseEntity.status(HttpStatus.CREATED).body(recorded);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSensorReading(@PathVariable Long id) {
        sensorReadingService.deleteSensorReading(id);
        return ResponseEntity.noContent().build();
    }
}
