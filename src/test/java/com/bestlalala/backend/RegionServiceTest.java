package com.bestlalala.backend;

import com.bestlalala.backend.domain.model.Region;
import com.bestlalala.backend.domain.service.RegionService;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

import static com.ninja_squad.dbsetup.Operations.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RegionServiceTest {

    @Autowired
    private RegionService regionService;

    @Autowired
    private DataSource dataSource;

    // DbSetup 객체를 매번 초기화
    @BeforeEach
    public void prepareDatabase() {
        // DbSetup의 operations 정의
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

        // DbSetup을 사용하여 DataSource에 대한 초기화
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operations);

        // 초기화 실행 (예외 발생 시 로깅)
        try {
            dbSetup.launch();
        } catch (Exception e) {
            e.printStackTrace(); // 예외가 발생하면 출력해봄
            throw new RuntimeException("DbSetup failed", e);
        }
    }

    @Test
    public void testServiceRegion() {
        // RegionService에서 모든 지역 가져오기
        List<Region> regionList = regionService.getAllRegions();

        // List의 크기가 4인지 확인
        assertThat(regionList).hasSize(4);
    }
}