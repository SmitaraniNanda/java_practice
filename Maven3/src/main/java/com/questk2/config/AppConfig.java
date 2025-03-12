package com.questk2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.questk2")
public class AppConfig {

    @Bean
    public String schoolName() {
        return "Spring Boot Academy";
    }
   @Bean
    public String courseName() {
        return "Java Spring Boot";
    }
}
