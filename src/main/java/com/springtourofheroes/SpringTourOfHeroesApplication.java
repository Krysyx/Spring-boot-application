package com.springtourofheroes;

import com.springtourofheroes.Config.MailConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties(MailConfigProperties.class)
public class SpringTourOfHeroesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTourOfHeroesApplication.class, args);
    }

}
