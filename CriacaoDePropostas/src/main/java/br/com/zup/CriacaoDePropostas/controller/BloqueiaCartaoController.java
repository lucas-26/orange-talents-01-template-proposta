package br.com.zup.CriacaoDePropostas.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import br.com.zup.CriacaoDePropostas.controller.validacao.AnaliseCartao;
import br.com.zup.CriacaoDePropostas.controller.validacao.CartaoReq;
import br.com.zup.CriacaoDePropostas.controller.validacao.GetIp;
import br.com.zup.CriacaoDePropostas.model.BloqueioCartao;
import br.com.zup.CriacaoDePropostas.model.Proposta;
import br.com.zup.CriacaoDePropostas.repository.BloqueiaCartaoRepository;
import br.com.zup.CriacaoDePropostas.repository.PropostaRepository;

@RestController
@RequestMapping("/BloqueiaCartao")
public class BloqueiaCartaoController {

	@Autowired
	BloqueiaCartaoRepository bloqueiaCartaoRepository;
	@Autowired
	PropostaRepository propostaRepository;
	@Autowired
	HttpServletRequest request;
	@Autowired
	public AnaliseCartao analisaCartao;
	
	@PostMapping(value = "/Bloquear/{idCartao}")
	public ResponseEntity<?> bloqueia(@NotNull @NotBlank @PathVariable("idCartao") String idCartao) {

		String ipAddress = GetIp.getIpAdress(request);
		String userAgent = GetIp.getAgent(request);

		Optional<Proposta> cartaoExiste = propostaRepository.findBycartaoId(idCartao);
		if (cartaoExiste.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Optional<BloqueioCartao> cartaoJaFoiBloqueado = bloqueiaCartaoRepository.findBycartaoId(idCartao);
		if (cartaoJaFoiBloqueado.isPresent()) {
			return ResponseEntity.status(422).build();
		}

		BloqueioCartao bloqueio = new BloqueioCartao(idCartao, ipAddress, userAgent);
		bloqueiaCartaoRepository.save(bloqueio);
		Object resultado = CartaoReq.BloquearCartaoNoLegado(idCartao, analisaCartao);
		return ResponseEntity.ok().body(resultado);
	}
	
	@GetMapping(value = "/ConsultarCartao/{idCartao}")
	public ResponseEntity<?> buscaCartoa(@NotNull @NotBlank @PathVariable("idCartao") String idCartao){
		Optional<BloqueioCartao> bloqueado = bloqueiaCartaoRepository.findBycartaoId(idCartao);
		if(bloqueado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(bloqueado.get().getId());
	}

}
