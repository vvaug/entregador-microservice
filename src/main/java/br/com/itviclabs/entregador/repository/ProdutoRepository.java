package br.com.itviclabs.entregador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.itviclabs.entregador.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
