package br.com.itviclabs.entregador.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itviclabs.entregador.dto.ConfirmacaoPedidoResponse;
import br.com.itviclabs.entregador.dto.PedidoRequest;
import br.com.itviclabs.entregador.service.EntregaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/entrega")
public class EntregaEndpoint {

	@Autowired
	private EntregaService entregaService;
	
	@PostMapping
	public ConfirmacaoPedidoResponse realizarEntrega(@RequestBody PedidoRequest pedidoRequest) {
		return entregaService.realizarEntrega(pedidoRequest);
	}
}
