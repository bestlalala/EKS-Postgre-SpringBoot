package com.bestlalala.backend;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@TestConfiguration
public class DataSourceTestConfig {

    @Bean
    public DataSource dataSource() {
        // PostgreSQL DataSource 설정
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/myworkdb")
                .username("mywork")
                .password("ys1234")
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}
