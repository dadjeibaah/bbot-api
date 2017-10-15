package com.onecreation.configs

import com.mongodb.MongoClient
import com.mongodb.MongoClientOptions
import com.mongodb.MongoClientURI
import com.mongodb.MongoCredential
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class MongoConfiguration {

    @Value('${mongodb.uri}')
    private String mongoUri

    @Bean MongoClient mongo() {
        System.out.println("Current url" + mongoUri)
        ArrayList<MongoCredential> mongoCredentials = new ArrayList<>()
        MongoClient mongo = new MongoClient(new MongoClientURI(mongoUri))

        return mongo
    }
}
