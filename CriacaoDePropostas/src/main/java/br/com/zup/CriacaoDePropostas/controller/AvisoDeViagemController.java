package br.com.zup.CriacaoDePropostas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.CriacaoDePropostas.controller.request.AvisoViagemLegadoRequest;
import br.com.zup.CriacaoDePropostas.controller.request.AvisoViagemRequest;
import br.com.zup.CriacaoDePropostas.controller.validacao.AnaliseCartao;
import br.com.zup.CriacaoDePropostas.controller.validacao.GetIp;
import br.com.zup.CriacaoDePropostas.model.AvisoDeViagem;
import br.com.zup.CriacaoDePropostas.repository.AvisoDeViagemRepository;
import br.com.zup.CriacaoDePropostas.repository.CartaoRepository;
import feign.Headers;

@RestController
@RequestMapping("/AvisoDeViagem")
public class AvisoDeViagemController {

	@Autowired
	AvisoDeViagemRepository avisoDeViagemRepository;
	@Autowired
	CartaoRepository cartaoRepository;
	@Autowired
	HttpServletRequest request;
	@Autowired
	AnaliseCartao analiseCartao;

	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar/{id}")
	@Headers("Content-Type: application/json")
	public ResponseEntity<?> cadastrar(@PathVariable("id") String id,
			@RequestBody @Valid AvisoViagemRequest avisoViagem) {

		String ipAddress = GetIp.getIpAdress(request);
		String userAgent = GetIp.getAgent(request);

		if (cartaoRepository.findByCartaoId(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		AvisoViagemLegadoRequest avisarViagemParaLegado = new AvisoViagemLegadoRequest(id,avisoViagem.getDestinoViagem(), avisoViagem.getDataTerminoViagem());

		ResponseEntity<?> response = avisarViagemParaLegado.avisaLegado(avisarViagemParaLegado, analiseCartao);
		if(response.getStatusCode() == HttpStatus.OK) {
			AvisoDeViagem avisoViagemSalvar = new AvisoDeViagem(id, avisoViagem.getDestinoViagem(),avisoViagem.getDataTerminoViagem(), ipAddress, userAgent);
			avisoDeViagemRepository.save(avisoViagemSalvar);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
}
