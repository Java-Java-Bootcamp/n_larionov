package com.example.demo;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmarketApplication.class, args);
    }
    @Bean
    public GroupedOpenApi customerApi() {
        return GroupedOpenApi.builder()
                .group("emarket-customer")
                .pathsToMatch("/customer/**")
                .build();
    }
    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("emarket-admin")
                .pathsToMatch("/admin/**")
                .build();
    }
}