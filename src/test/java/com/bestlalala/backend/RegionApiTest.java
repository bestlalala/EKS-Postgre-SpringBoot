package com.bestlalala.backend;

import com.bestlalala.backend.presentation.api.RegionApiController;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
public class RegionApiTest {
    @Autowired
    private RegionApiController regionApi;

    @Mock
    private RegionRepository regionRepository;

    @Test
    public void testGetAllRegions() {
        var result = regionApi.getAllRegions();
        assertThat(result.getRegionDtoList()).hasSize(4);
    }
}

