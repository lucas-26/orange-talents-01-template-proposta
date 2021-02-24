package br.com.zup.CriacaoDePropostas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.CriacaoDePropostas.controller.request.AssociarCartaoRequest;
import br.com.zup.CriacaoDePropostas.controller.request.ResultadoCarteira;
import br.com.zup.CriacaoDePropostas.controller.validacao.AnaliseCartao;
import br.com.zup.CriacaoDePropostas.model.AssociarCartao;
import br.com.zup.CriacaoDePropostas.repository.AssociarCartaoRepository;
import br.com.zup.CriacaoDePropostas.repository.CartaoRepository;
import feign.Headers;

@RestController
@RequestMapping("/AssociarCartao")
public class AssociaCartaoController {

	@Autowired
	AssociarCartaoRepository associarCartaoRepository;
	@Autowired
	CartaoRepository cartaoRepository;
	@Autowired
	AnaliseCartao AnaliseCartao;

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	@Headers("Content-Type: application/json")
	private ResponseEntity<?> cadastrarAssociacao(@PathVariable("id") String id,
			@RequestBody @Valid AssociarCartaoRequest cartao) {

		if (cartaoRepository.findByCartaoId(id).isEmpty()) {
			ResponseEntity.status(404).body("message: Cartão não foi encontrado");
		}

		if (associarCartaoRepository.findByCartaoId(id).isPresent()) {
			ResponseEntity.status(422).body("message: Esse cartao já está associado com uma carteira");
		}

		ResponseEntity<ResultadoCarteira> associarCartaParaUmaCarteira = cartao.AssociarCartaParaUmaCarteira(id, cartao,AnaliseCartao);
		AssociarCartao cartao2 = cartao.converteRequestParaCartao(id, associarCartaParaUmaCarteira.getBody().getId(),
				cartao.getEmail(), associarCartaParaUmaCarteira.getBody().getResultado(), cartao.getCarteira());
		
		if(associarCartaParaUmaCarteira.getStatusCode() == HttpStatus.OK) {
			System.out.println(associarCartaParaUmaCarteira);
			associarCartaoRepository.save(cartao2);
		}
		return ResponseEntity.ok().build();
	}
}
