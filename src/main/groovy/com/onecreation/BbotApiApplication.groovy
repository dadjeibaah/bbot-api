package com.onecreation

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
class BbotApiApplication {

	static void main(String[] args) {
		SpringApplication.run BbotApiApplication, args
	}
}
