package com.controlpoint.service;

import com.controlpoint.model.Asset;
import com.controlpoint.repository.AssetRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AssetService {
    
    private final AssetRepository assetRepository;
    
    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }
    
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }
    
    public Optional<Asset> getAssetById(Long id) {
        return assetRepository.findById(id);
    }
    
    public Asset createAsset(Asset asset) {
        return assetRepository.save(asset);
    }
    
    public Asset updateAsset(Long id, Asset asset) {
        return assetRepository.findById(id)
            .map(existing -> {
                existing.setName(asset.getName());
                existing.setType(asset.getType());
                existing.setStatus(asset.getStatus());
                return assetRepository.save(existing);
            })
            .orElseThrow(() -> new RuntimeException("Asset not found with id: " + id));
    }
    
    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
}
