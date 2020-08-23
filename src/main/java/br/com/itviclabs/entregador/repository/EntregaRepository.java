package br.com.itviclabs.entregador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itviclabs.entregador.domain.Entrega;

public interface EntregaRepository extends JpaRepository<Entrega, Long>{

}
