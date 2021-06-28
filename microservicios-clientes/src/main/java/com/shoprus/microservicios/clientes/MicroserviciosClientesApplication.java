package com.shoprus.microservicios.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.shoprus.microservicios.commons.clientes.models.entities"}
)
@ComponentScan({
	"com.shoprus.microservicios.commons.utils",
	"com.shoprus.microservicios.clientes"
})
public class MicroserviciosClientesApplication {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosClientesApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(env.getProperty("gateway.ip"));
			}
		};
	}
}
