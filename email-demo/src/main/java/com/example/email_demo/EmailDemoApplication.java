package com.example.email_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
@EnableDiscoveryClient
public class EmailDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailDemoApplication.class, args);
	}

}
