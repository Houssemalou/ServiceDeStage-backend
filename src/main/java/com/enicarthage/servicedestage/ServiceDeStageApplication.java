package com.enicarthage.servicedestage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.enicarthage.servicedestage.model")
public class ServiceDeStageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDeStageApplication.class, args);
	}


}
