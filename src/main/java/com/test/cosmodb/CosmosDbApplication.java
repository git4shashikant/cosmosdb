package com.test.cosmodb;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCosmosRepositories
public class CosmosDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosmosDbApplication.class, args);
    }
}
