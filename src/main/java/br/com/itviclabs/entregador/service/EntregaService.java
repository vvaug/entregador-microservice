package br.com.itviclabs.entregador.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.itviclabs.entregador.client.RestauranteClient;
import br.com.itviclabs.entregador.domain.Entrega;
import br.com.itviclabs.entregador.domain.Produto;
import br.com.itviclabs.entregador.dto.ConfirmacaoPedidoResponse;
import br.com.itviclabs.entregador.dto.PedidoRequest;
import br.com.itviclabs.entregador.dto.ProdutoRequest;
import br.com.itviclabs.entregador.repository.EntregaRepository;
import br.com.itviclabs.entregador.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EntregaService{
	
	@Autowired
	private EntregaRepository entregaRepository;
	@Autowired
	private RestauranteClient restauranteClient;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ConfirmacaoPedidoResponse realizarEntrega(PedidoRequest pedidoRequest) {
		
		log.info("Processando pedido de entrega");
		
		List<Produto> produtos = obterProdutos(pedidoRequest.getProdutos());
		
		log.info("Produtos: {}", pedidoRequest.getProdutos());
		
		Entrega entrega = Entrega.builder()
							.logradouro(pedidoRequest.getLogradouro())
							.numero(pedidoRequest.getNumero())
							.produtos(produtos)
							.nomeCliente(pedidoRequest.getNomeCliente())
							.build();
		
		entregaRepository.save(entrega);
		
		return ConfirmacaoPedidoResponse.builder()
					.entrega(true)
					.produtos(pedidoRequest.getProdutos())
					.tempoDeEspera("entrega em até 1 hora")
					.build();
	}

	@HystrixCommand(fallbackMethod = "obterProdutosFallback", threadPoolKey = "obterProdutosThreadPool")
	public List<Produto> obterProdutos(List<ProdutoRequest> produtos) {
		
		log.info("Buscando produtos no serviço Restaurante");
		
		List<Produto> entities =  produtos.stream()
				.map(request ->
					  restauranteClient.getProduto(request.getId().toString())
				)
				.collect(Collectors.toList());
		
		log.info("persistindo produtos na base do servico Entrega : {}", entities);
		
		produtoRepository.saveAll(entities);
		
		return entities;
	}
	
	protected List<Produto> obterProdutosFallback(){
		log.warn("não foi possível comunicar-se com serviço Restaurante para obter os produtos.");
		return new ArrayList<Produto>();
	}

	public Page<Entrega> findAll(Pageable pageable) {
		return entregaRepository.findAll(pageable);
	}

	
}
