package com.controlpoint.config;

import com.controlpoint.model.Asset;
import com.controlpoint.model.AssetStatus;
import com.controlpoint.service.AssetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    
    @Bean
    public CommandLineRunner initializeData(AssetService assetService) {
        return args -> {
            // Create sample assets
            Asset pump = new Asset("Pump-001", "Pump", AssetStatus.RUNNING);
            Asset motor = new Asset("Motor-001", "Motor", AssetStatus.RUNNING);
            Asset conveyor = new Asset("Conveyor-001", "Conveyor", AssetStatus.STOPPED);
            
            // Save to database
            assetService.createAsset(pump);
            assetService.createAsset(motor);
            assetService.createAsset(conveyor);
            
            System.out.println("Sample assets preloaded successfully!");
            System.out.println("Assets: Pump-001 (Running), Motor-001 (Running), Conveyor-001 (Stopped)");
        };
    }
}
