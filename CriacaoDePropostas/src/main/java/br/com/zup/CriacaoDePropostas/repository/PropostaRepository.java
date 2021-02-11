package br.com.zup.CriacaoDePropostas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.CriacaoDePropostas.model.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {

	public Optional<Proposta> findByRgCpf(String documento);
}
