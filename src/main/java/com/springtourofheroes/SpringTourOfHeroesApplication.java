package com.springtourofheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringTourOfHeroesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTourOfHeroesApplication.class, args);
    }

}
