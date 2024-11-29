package com.bestlalala.backend.presentation.api;

import com.bestlalala.backend.domain.service.RegionService;
import com.bestlalala.backend.presentation.dto.RegionDto;
import com.bestlalala.backend.presentation.dto.RegionsDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RegionApiController {
    private final RegionService regionService;
    private static final Logger LOGGER =
            LoggerFactory.getLogger(HealthApiController.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RegionsDto getAllRegions(){
        LOGGER.info("getAllRegions");

        var allRegions = regionService.getAllRegions();
        var dtoList = new ArrayList<RegionDto>();
        allRegions.forEach(region -> {
            var dto = new RegionDto(region);
            dtoList.add(dto);
        });
        return new RegionsDto(dtoList);
    }
}

