package com.onecreation

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
@EnableMongoRepositories
class BbotApiApplication {

	static void main(String[] args) {
		SpringApplication.run BbotApiApplication, args
	}
}
