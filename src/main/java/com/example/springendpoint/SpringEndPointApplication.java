package com.example.springendpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringEndPointApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEndPointApplication.class, args);
    }

}
