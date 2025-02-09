package com.avaxia.lms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
@ImportAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@SpringBootTest
class LmsApplicationTests {
    @Test
    void contextLoads() {
    }
}
