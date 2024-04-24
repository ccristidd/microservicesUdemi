package com.eazybytes.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
/*
* if the spring boot components are not created in the same package with the AccountsApplication class then you
* need to provide their location. for example
* @ComponentScans({@ComponentScan("com.eazybytes.accounts.controller") })
* @EnableJpaRepositories("com.eazybytes.accounts.repository")
* @EntityScan("com.eazybytes.accounts.model")
*/
@EnableJpaRepositories("com.eazybytes.accounts.repository")
@EntityScan("com.eazybytes.accounts.model")
@ComponentScan(basePackages = "com.eazybytes")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts Microservices REST API Documentation",
                description = "EazyBank Accounts Microservices REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Cristi D",
                        email = "cristid@@yahoo.comm",
                        url = "www.google.ro"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "www.google.ro"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "EazyBank Accounts Microservices REST API Documentation",
                url = "www.google.ro"
        )
)


public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
