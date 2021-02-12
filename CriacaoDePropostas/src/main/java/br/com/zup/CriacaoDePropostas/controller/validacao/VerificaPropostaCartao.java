package br.com.zup.CriacaoDePropostas.controller.validacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.zup.CriacaoDePropostas.controller.response.CartaoResponse;
import br.com.zup.CriacaoDePropostas.model.Proposta;
import br.com.zup.CriacaoDePropostas.model.Status;
import br.com.zup.CriacaoDePropostas.repository.PropostaRepository;

@Component
public class VerificaPropostaCartao {

	@Autowired
	PropostaRepository propostaRepository;

	@Autowired
	public AnaliseCartao analisaCartao;

	@Scheduled(fixedDelayString = "${periodicidade.executa-operacao}")
	private void buscaCartaoComProposta() {

		List<Proposta> propostas = propostaRepository.findAll();
		propostas.forEach(proposta -> {
			if (proposta.getStatus() == Status.ELEGIVEL) {
				CartaoResponse value = analisaCartao.verificaSePropostatemCartao(proposta.getId().toString());
				proposta.InsereIdCartao(value.getId());
				propostaRepository.save(proposta);
			}
		});
	}

}
