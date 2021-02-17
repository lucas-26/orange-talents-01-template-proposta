package br.com.zup.CriacaoDePropostas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.CriacaoDePropostas.model.Biometria;

@Repository
public interface BiometriaRepository extends JpaRepository<Biometria, Long>{

}
