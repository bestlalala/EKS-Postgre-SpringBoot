package com.bestlalala.backend.domain.service;

import com.bestlalala.backend.RegionRepository;
import com.bestlalala.backend.domain.model.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;

    @Override
    public List<Region> getAllRegions() {
        var regionEntities = regionRepository.findAll();
        var regionList = new ArrayList<Region>();
        regionEntities.forEach(entity -> regionList.add(new Region(entity)));
        return regionList;
    }
}