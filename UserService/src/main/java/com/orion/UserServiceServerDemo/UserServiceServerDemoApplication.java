package com.orion.UserServiceServerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceServerDemoApplication.class, args);
	}

}
