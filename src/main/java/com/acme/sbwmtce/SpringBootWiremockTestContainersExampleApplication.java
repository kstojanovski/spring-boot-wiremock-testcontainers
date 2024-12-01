package com.acme.sbwmtce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class SpringBootWiremockTestContainersExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWiremockTestContainersExampleApplication.class, args);
	}

}
