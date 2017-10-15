package com.onecreation.configs

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoClientFactoryBean

import java.util.logging.Logger

@Configuration
class MongoConfiguration {
    static Logger log = LoggerFactory.getLogger(MongoConfiguration.class)

    @Value('${mongodb.uri}')
    private String mongoUri

    @Bean MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean()
        log.info("Current Mongo URI: ${mongoUri}")
        mongo.setHost(mongoUri)
        return mongo
    }
}
