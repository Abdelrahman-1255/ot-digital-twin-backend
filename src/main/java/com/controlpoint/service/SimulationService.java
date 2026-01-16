package com.controlpoint.service;

import com.controlpoint.model.Asset;
import com.controlpoint.model.AssetStatus;
import com.controlpoint.model.SensorReading;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class SimulationService {
    
    private final AssetService assetService;
    private final SensorReadingService sensorReadingService;
    private final Random random = new Random();
    
    public SimulationService(AssetService assetService, SensorReadingService sensorReadingService) {
        this.assetService = assetService;
        this.sensorReadingService = sensorReadingService;
    }
    
    @Scheduled(fixedDelay = 5000)
    public void simulateSensorReadings() {
        List<Asset> assets = assetService.getAllAssets();
        
        for (Asset asset : assets) {
            // Generate random temperature (50-100°C)
            Double temperature = 50 + (random.nextDouble() * 50);
            
            // Generate random pressure (900-1100 kPa)
            Double pressure = 900 + (random.nextDouble() * 200);
            
            // Randomly assign asset status
            AssetStatus[] statuses = AssetStatus.values();
            AssetStatus randomStatus = statuses[random.nextInt(statuses.length)];
            asset.setStatus(randomStatus);
            assetService.updateAsset(asset.getId(), asset);
            
            // Create and save sensor reading
            SensorReading reading = new SensorReading(
                asset.getId(),
                Math.round(temperature * 100.0) / 100.0,
                Math.round(pressure * 100.0) / 100.0,
                LocalDateTime.now()
            );
            
            sensorReadingService.recordSensorReading(reading);
            
            System.out.println("Simulated reading for asset " + asset.getId() + 
                " - Temp: " + temperature + "°C, Pressure: " + pressure + "kPa, Status: " + randomStatus);
        }
    }
}
