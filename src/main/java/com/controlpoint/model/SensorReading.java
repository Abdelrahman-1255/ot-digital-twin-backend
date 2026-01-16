package com.controlpoint.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_readings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorReading {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long assetId;
    
    @Column(nullable = false)
    private Double temperature;
    
    @Column(nullable = false)
    private Double pressure;
    
    @Column(nullable = false)
    private LocalDateTime timestamp;
    
    public SensorReading(Long assetId, Double temperature, Double pressure, LocalDateTime timestamp) {
        this.assetId = assetId;
        this.temperature = temperature;
        this.pressure = pressure;
        this.timestamp = timestamp;
    }
}
