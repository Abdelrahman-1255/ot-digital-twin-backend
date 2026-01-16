package com.controlpoint.repository;

import com.controlpoint.model.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {
    List<SensorReading> findByAssetId(Long assetId);
    
    @Query("SELECT s FROM SensorReading s WHERE s.assetId = :assetId ORDER BY s.timestamp DESC LIMIT 1")
    Optional<SensorReading> findLatestByAssetId(@Param("assetId") Long assetId);
}
