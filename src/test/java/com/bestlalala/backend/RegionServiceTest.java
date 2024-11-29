package com.bestlalala.backend;

import com.bestlalala.backend.domain.model.Region;
import com.bestlalala.backend.domain.service.RegionService;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

import static com.ninja_squad.dbsetup.Operations.*;

@SpringBootTest
public class RegionServiceTest {
    @Autowired
    private RegionService regionService;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @BeforeEach
    public void prepareDatabase() {
        var operations = sequenceOf(
                deleteAllFrom("region"),
                insertInto("region")
                        .columns("region_id", "region_name", "creation_timestamp")
                        .values(1, "지역1", LocalDateTime.now())
                        .values(2, "지역2", LocalDateTime.now())
                        .values(3, "지역3", LocalDateTime.now())
                        .values(4, "지역4", LocalDateTime.now())
                        .build()
        );
        var dbSetup = new DbSetup(new DataSourceDestination(dataSource), operations);
        dbSetup.launch();
    }

    @Test
    @Tag("DBRequired")
    public void testServiceRegion() {
        List<Region> regionList = regionService.getAllRegions();
        Assertions.assertEquals(4, regionList.size());
    }
}