package com.bestlalala.backend.domain.model;

import com.bestlalala.backend.RegionEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
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
}
