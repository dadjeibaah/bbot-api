package com.onecreation.configs

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoClientFactoryBean

@Configuration
class MongoConfiguration {

    @Value('${mongodb.uri}')
    private String mongoUri

    @Bean MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost(mongoUri)
        return mongo
    }
}
