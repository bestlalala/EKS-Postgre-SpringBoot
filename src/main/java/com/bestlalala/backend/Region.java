package com.bestlalala.backend;

import java.time.LocalDateTime;

public class Region {
    private Integer regionId;
    private String regionName;
    private LocalDateTime creationTimestamp;

    public Region(Integer regionId, String regionName, LocalDateTime creationTimestamp) {
        if (regionName == null) {
            throw new IllegalArgumentException("regionName cannot be null");
        }
        this.regionId = regionId;
        this.regionName = regionName;
        this.creationTimestamp = creationTimestamp;
    }

    public Region(RegionEntity regionEntity) {
        this(regionEntity.getRegionId(), regionEntity.getRegionName(), regionEntity.getCreationTimestamp());
    }

    // Getters and Setters
}
