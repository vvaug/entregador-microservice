package br.com.itviclabs.entregador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EntregadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntregadorApplication.class, args);
	}

}
