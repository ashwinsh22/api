package com.scb.personalBanking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenApi() {
		
		return new OpenAPI()
				.components(new Components())
				.info(new Info()
						.title("Spring Boot APIs")
						.description("APIs powered by Spring Boot framework")
						.version("1.1.0")
						
					);
				
	}

}

