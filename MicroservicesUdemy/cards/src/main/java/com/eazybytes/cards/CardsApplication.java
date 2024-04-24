package com.eazybytes.cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*
 * **because the components are in the same package as the main class "CardsApplication" we don't need the below definitions
 * @ComponentScans({@ComponentScan("com.eazybytes.cards.controller"), @ComponentScan("com.eazybytes.cards.service")})
 * @EnableJpaRepositories("com.eazybytes.cards.repository")
 * @EntityScan("com.eazybytes.cards.entity")
 */
@EnableJpaAuditing(auditorAwareRef = "auditAwareImplCards")
@OpenAPIDefinition(
        info = @Info(
                title = "Cards microservice REST API Documentation",
                description = "EazyBank Cards microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Cristi D",
                        email = "email@email.com",
                        url = "https://inglearn.udemy.com/course/master-microservices-with-spring-docker-kubernetes/learn/lecture/39943242#overview"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "www.google.ro"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "EazyBank Cards microservice REST API Documentation",
                url = "https://www.eazybytes.com/swagger-ui.html"
        )
)
public class CardsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CardsApplication.class, args);
    }
}
