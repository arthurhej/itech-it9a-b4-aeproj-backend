package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class AppConfig {

    public @Bean MongoClient mongoClient() {

        return MongoClients.create("mongodb://localhost:27017");
    }

    public @Bean MongoTemplate mongoTemplate() {

        return new MongoTemplate(mongoClient(), "highscores");
    }

}
