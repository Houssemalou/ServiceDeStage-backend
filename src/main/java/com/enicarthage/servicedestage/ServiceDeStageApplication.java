package com.enicarthage.servicedestage;

import com.enicarthage.servicedestage.service.UtilisateurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(scanBasePackages = "com.enicarthage.servicedestage")
public class ServiceDeStageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDeStageApplication.class, args);
	}


}
