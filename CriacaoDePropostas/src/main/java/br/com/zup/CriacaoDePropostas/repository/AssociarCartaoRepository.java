package br.com.zup.CriacaoDePropostas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.CriacaoDePropostas.model.AssociarCartao;

@Repository
public interface AssociarCartaoRepository extends JpaRepository<AssociarCartao, Long>{
	
	public Optional<AssociarCartao> findByCartaoId(String cartaoId);

}
