package com.onecreation

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableAutoConfiguration
class BbotApiApplication {

	static void main(String[] args) {
		SpringApplication.run BbotApiApplication, args
	}
}
