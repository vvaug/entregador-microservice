package br.com.itviclabs.entregador.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonInclude(Include.NON_NULL)
public class PedidoRequest {

	private List<ProdutoRequest> produtos;
	private Boolean entrega;
	private String formaPagamento;
	private String nomeCliente;
	private String telefoneCliente;
	private String logradouro;
	private String numero;
}
