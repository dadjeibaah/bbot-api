package com.onecreation

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
@EnableTransactionManagement
@EnableNeo4jRepositories
class BbotApiApplication {

	static void main(String[] args) {
		SpringApplication.run BbotApiApplication, args
	}
}
