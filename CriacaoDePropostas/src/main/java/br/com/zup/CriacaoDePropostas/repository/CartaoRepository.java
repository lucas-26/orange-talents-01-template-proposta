package br.com.zup.CriacaoDePropostas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



import br.com.zup.CriacaoDePropostas.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long>{

	public Optional<Cartao> findByCartaoId(String ídcartao);
	
}
