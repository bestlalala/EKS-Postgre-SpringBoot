package com.bestlalala.backend;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.time.LocalDateTime;

import static com.ninja_squad.dbsetup.Operations.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(DataSourceTestConfig.class)  // DataSource 설정을 가져오기
public class RegionRepositoryTest {

    @Autowired
    private RegionRepository regionRepository;

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
    public void testFindAll() {
        prepareDatabase();

        var result = regionRepository.findAll();
        assertThat(result).hasSize(4);
    }
}