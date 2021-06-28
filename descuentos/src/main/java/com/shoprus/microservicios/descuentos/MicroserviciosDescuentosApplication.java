package com.shoprus.microservicios.descuentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.shoprus.microservicios.commons.descuentos.models.entities"})
@ComponentScan({
	"com.shoprus.microservicios.commons.utils",
	"com.shoprus.microservicios.descuentos"
})
public class MicroserviciosDescuentosApplication {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosDescuentosApplication.class, args);
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