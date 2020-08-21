package br.com.itviclabs.entregador.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProdutoRequest {

	private Long id;
	private Integer quantidade;
}
