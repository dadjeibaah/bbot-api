package com.onecreation.configs

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoClientFactoryBean

import java.util.logging.Logger

@Configuration
class MongoConfiguration {

    @Value('${mongodb.uri}')
    private String mongoUri

    @Bean MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean()
       System.out.println("Current mongodb: ${mongoUri}")
        mongo.setHost(mongoUri)
        return mongo
    }
}
