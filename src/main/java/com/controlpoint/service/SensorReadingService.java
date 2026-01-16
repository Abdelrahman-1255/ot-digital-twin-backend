package com.controlpoint.service;

import com.controlpoint.model.SensorReading;
import com.controlpoint.repository.SensorReadingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SensorReadingService {
    
    private final SensorReadingRepository sensorReadingRepository;
    
    public SensorReadingService(SensorReadingRepository sensorReadingRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
    }
    
    public List<SensorReading> getAllSensorReadings() {
        return sensorReadingRepository.findAll();
    }
    
    public Optional<SensorReading> getSensorReadingById(Long id) {
        return sensorReadingRepository.findById(id);
    }
    
    public List<SensorReading> getSensorReadingsByAssetId(Long assetId) {
        return sensorReadingRepository.findByAssetId(assetId);
    }
    
    public Optional<SensorReading> getLatestSensorReadingByAssetId(Long assetId) {
        return sensorReadingRepository.findLatestByAssetId(assetId);
    }
    
    public SensorReading recordSensorReading(SensorReading sensorReading) {
        return sensorReadingRepository.save(sensorReading);
    }
    
    public void deleteSensorReading(Long id) {
        sensorReadingRepository.deleteById(id);
    }
}
