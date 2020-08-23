package br.com.itviclabs.entregador.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Entrega {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToMany
	@JoinTable(name = "entrega_produtos",
			   joinColumns = @JoinColumn(name = "produtos_id"),
			   inverseJoinColumns = @JoinColumn(name = "entrega_id"))
	private List<Produto> produtos;
	private String logradouro;
	private String numero;
	private String nomeCliente;
}
