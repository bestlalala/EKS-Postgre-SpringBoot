package com.bestlalala.backend;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "REGION")
public class RegionEntity extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGION_ID")
    private Integer regionId;

    @Column(name = "REGION_NAME")
    private String regionName;

    @Column(name = "CREATION_TIMESTAMP")
    private LocalDateTime creationTimestamp;

    // Getters and Setters
}