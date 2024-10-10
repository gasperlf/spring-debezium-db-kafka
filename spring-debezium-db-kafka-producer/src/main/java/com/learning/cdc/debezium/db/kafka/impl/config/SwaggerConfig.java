package com.learning.cdc.debezium.db.kafka.impl.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi customOpenAPI() {
        return GroupedOpenApi.builder()
                .group("product-api") // Specify a group name
                .packagesToScan("com.learning.cdc.debezium.db.kafka.impl.config.controller") // Update with your package
                .build();
    }
}
