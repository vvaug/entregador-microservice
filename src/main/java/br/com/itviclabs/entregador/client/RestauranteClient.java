package br.com.itviclabs.entregador.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.itviclabs.entregador.domain.Produto;

@FeignClient("restaurante-vo-maria")
public interface RestauranteClient {

	@GetMapping("/vo-maria/api/v1/produto/{id}")
	public Produto getProduto(@PathVariable("id") String id);
}
