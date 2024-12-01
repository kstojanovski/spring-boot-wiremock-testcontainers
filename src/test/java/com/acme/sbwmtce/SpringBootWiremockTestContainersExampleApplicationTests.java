package com.acme.sbwmtce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestContainersConfiguration.class)
@SpringBootTest
class SpringBootWiremockTestContainersExampleApplicationTests {

	@Test
	void contextLoads() {
	}

}
