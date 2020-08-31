package br.com.itviclabs.entregador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableFeignClients
@EnableResourceServer
@EnableCircuitBreaker
public class EntregadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntregadorApplication.class, args);
	}

}
