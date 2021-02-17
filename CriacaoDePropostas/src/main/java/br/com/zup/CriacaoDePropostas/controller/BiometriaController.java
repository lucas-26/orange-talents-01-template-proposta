package br.com.zup.CriacaoDePropostas.controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.CriacaoDePropostas.controller.request.BiometriaRequest;
import br.com.zup.CriacaoDePropostas.model.Biometria;
import br.com.zup.CriacaoDePropostas.model.Proposta;
import br.com.zup.CriacaoDePropostas.repository.BiometriaRepository;
import br.com.zup.CriacaoDePropostas.repository.PropostaRepository;

@RequestMapping("/Biometria")
@RestController
public class BiometriaController {

	@Autowired
	BiometriaRepository biometriaRepository;
	@Autowired
	PropostaRepository repository;

	@PostMapping(value = "cadastro/{idCartao}")
	public ResponseEntity<?> cadastraBiometria(@PathVariable("idCartao") String idCartao,
			@Valid @RequestBody BiometriaRequest biometriaRequest, UriComponentsBuilder uri) {

		boolean existeCartao = Proposta.existeIdCartao(repository, idCartao);

		if (existeCartao == false) {
			return ResponseEntity.notFound().build();
		}
		Biometria biometria = BiometriaRequest.ConverteParaBiometria(idCartao, biometriaRequest);
		URI location = uri.path("Biometria/{biometria}").buildAndExpand(biometria.getFingerprint()).toUri();

		biometriaRepository.save(biometria);
		return ResponseEntity.created(location).build();
	}

}
