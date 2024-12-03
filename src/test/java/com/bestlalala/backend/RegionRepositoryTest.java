package com.bestlalala.backend;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.time.LocalDateTime;

import static com.ninja_squad.dbsetup.Operations.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RegionRepositoryTest {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private DataSource dataSource;  // DataSource 주입

    private DbSetup dbSetup;

    @BeforeEach
    public void prepareDatabase() {
        // DbSetup 초기화 및 설정
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
        dbSetup = new DbSetup(new DataSourceDestination(dataSource), operations);
        dbSetup.launch();  // 데이터베이스 초기화
    }

    @Test
    public void testFindAll() {
        // prepareDatabase()는 @BeforeEach에서 이미 호출됨
        var result = regionRepository.findAll();
        assertThat(result).hasSize(4);
    }
}