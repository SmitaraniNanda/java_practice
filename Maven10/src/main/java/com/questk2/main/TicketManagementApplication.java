package com.questk2.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * The main entry point for the Ticket Management System application.
 * This class bootstraps the Spring Boot application.
 */
@SpringBootApplication
@EntityScan("com.questk2.entity") // Scans for JPA entity classes in the specified package
@ComponentScan("com.questk2") // Scans for Spring components, services, and controllers
@EnableJpaRepositories("com.questk2.repository") // Enables JPA repositories in the specified package
@OpenAPIDefinition(info = @Info(title = "Support Ticket Management System", version = "1.0", description = "This API manages the tickets from users and admin."))
public class TicketManagementApplication {

    /**
     * The main method that starts the Spring Boot application.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(TicketManagementApplication.class, args);
    }
}


