package com.bestlalala.backend;

import com.bestlalala.backend.presentation.api.HealthApiController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HealthApiTest {

    @Test
    public void testHealthOk(){
        var api = new HealthApiController();
        var health = api.getHealth();
        assertThat(health.getStatus()).isEqualTo("OK");
    }
}