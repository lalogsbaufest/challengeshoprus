package com.shoprus.microservicios.gateway;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@SpringBootApplication
public class GatewayApplication {

	@Autowired
  	RouteDefinitionLocator locator;

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	@Primary
	public SwaggerResourcesProvider swaggerResourcesProvider(DiscoveryClient discoveryClient,
			@Value("${spring.application.name}") String gateway) {
		return () -> discoveryClient.getServices().stream().filter(service -> !service.equals(gateway)).map(service -> {
			var resource = new SwaggerResource();
			resource.setName(service);
			resource.setLocation(String.format("/api/%s/v3/api-docs", service.replace("microservicio-", "")));
			return resource;
		}).collect(Collectors.toList());
	}
}
