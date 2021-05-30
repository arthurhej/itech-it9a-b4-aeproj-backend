package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * Configuration class for connection to mongo database
 */
@Configuration
@Profile({"production"})
public class AppConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    public @Bean MongoClient mongoClient() {

        return MongoClients.create("mongodb://localhost:27017");
    }

    public @Bean MongoTemplate mongoTemplate() {

        try {
            return new MongoTemplate(mongoClient(), "highscores");
        } catch (Exception e) {
            LOGGER.error("mongo database unreachable", e);
            return null;
        }
    }

}
