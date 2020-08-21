package br.com.itviclabs.entregador.service;

import org.springframework.stereotype.Service;

import br.com.itviclabs.entregador.dto.ConfirmacaoPedidoResponse;
import br.com.itviclabs.entregador.dto.PedidoRequest;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntregaService{
	
	public ConfirmacaoPedidoResponse realizarEntrega(PedidoRequest pedidoRequest) {
		log.info("Processando pedido de entrega");
		log.info("Produtos: {}", pedidoRequest.getProdutos());
		return ConfirmacaoPedidoResponse.builder()
					.entrega(true)
					.produtos(pedidoRequest.getProdutos())
					.tempoDeEspera("entrega em até 1 hora")
					.build();
	}

	
}
