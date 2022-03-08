package com.example.demoMysqltutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoMysqltutorialApplication {

	@Bean
	public RestTemplate getRestTemplate() {
	return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoMysqltutorialApplication.class, args);
	}

}
