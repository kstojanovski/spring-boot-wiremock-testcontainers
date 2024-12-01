package com.acme.sbwmtce;

import org.springframework.boot.SpringApplication;

public class TestSpringBootWiremockTestContainersExampleApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringBootWiremockTestContainersExampleApplication::main).with(TestContainersConfiguration.class).run(args);
	}

}
