package br.com.zup.CriacaoDePropostas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.CriacaoDePropostas.model.BloqueioCartao;

@Repository
public interface BloqueiaCartaoRepository extends JpaRepository<BloqueioCartao, Long> {

	public Optional<BloqueioCartao> findBycartaoId(String idCartao);

}
