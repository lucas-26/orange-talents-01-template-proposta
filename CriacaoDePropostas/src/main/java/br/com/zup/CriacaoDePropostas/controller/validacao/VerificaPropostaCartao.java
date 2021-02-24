package br.com.zup.CriacaoDePropostas.controller.validacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.zup.CriacaoDePropostas.controller.response.CartaoResponse;
import br.com.zup.CriacaoDePropostas.model.Cartao;
import br.com.zup.CriacaoDePropostas.model.Proposta;
import br.com.zup.CriacaoDePropostas.model.Status;
import br.com.zup.CriacaoDePropostas.repository.CartaoRepository;
import br.com.zup.CriacaoDePropostas.repository.PropostaRepository;

@Component
public class VerificaPropostaCartao {

	@Autowired
	PropostaRepository propostaRepository;

	@Autowired
	public AnaliseCartao analisaCartao;
	
	@Autowired
	CartaoRepository cartaoRepository;

	@Scheduled(fixedDelayString = "${periodicidade.executa-operacao}")
	public void buscaCartaoComProposta() {
		try {

			List<Proposta> propostas = propostaRepository.findAll();
			propostas.forEach(proposta -> {
				if (proposta.getStatus() == Status.ELEGIVEL && proposta.getIdCartao() == null) {
					CartaoResponse value = analisaCartao.verificaSePropostatemCartao(proposta.getId().toString());
					CartaoReq reqCartao = new CartaoReq(proposta.getRgCpf(), proposta.getNome(), proposta.getId().toString());
					ResponseEntity<?> valor = analisaCartao.getNumeroCartao(reqCartao);
					if(value == null) {
						return ;
					}
					String numeroCartao = valor.getHeaders().getLocation().toString().substring(30);
					cartaoRepository.save(new Cartao(numeroCartao, proposta.getNome()));
					proposta.InsereIdCartao(numeroCartao);
					propostaRepository.save(proposta);
				}
			});

		} catch (Exception e) {
			throw e;
		}
	}

}
