package com.bestlalala.backend.presentation.api;

import com.bestlalala.backend.presentation.dto.HealthDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class HealthApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HealthApiController.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HealthDto getHealth(){
        LOGGER.info("Health GET API Called");
        var health = new HealthDto();
        health.setStatus("OK");
        return health;
    }
}