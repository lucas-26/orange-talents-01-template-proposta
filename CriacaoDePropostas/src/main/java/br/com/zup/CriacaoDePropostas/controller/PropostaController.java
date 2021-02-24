package br.com.zup.CriacaoDePropostas.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.CriacaoDePropostas.controller.request.PropostarRequest;
import br.com.zup.CriacaoDePropostas.controller.response.PropostaResponse;
import br.com.zup.CriacaoDePropostas.controller.validacao.AnaliseCliente;
import br.com.zup.CriacaoDePropostas.controller.validacao.AnaliseCliente.ConsultaStatusResquest;
import br.com.zup.CriacaoDePropostas.controller.validacao.DocumentoValidacao;
import br.com.zup.CriacaoDePropostas.model.Proposta;
import br.com.zup.CriacaoDePropostas.repository.PropostaRepository;
import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
@RequestMapping("/Proposta")
public class PropostaController {
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new DocumentoValidacao());
	}

	@Autowired
	private PropostaRepository propostaRepository;
	@Autowired
	private AnaliseCliente analiseCliente;
	
	  private Tracer tracer = null;

	  public PropostaController(Tracer tracer) {
	    this.tracer = tracer;
	  }
	
	@PostMapping
	public ResponseEntity<?> CadastrarProposta(@RequestBody @Valid PropostarRequest propostaRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		Proposta proposta = PropostarRequest.converter(propostaRequest);
		String documento = propostaRequest.getRgCpf();
		Optional<Proposta> validaDocumentoExiste = propostaRepository.findByRgCpf(documento);
		if (!validaDocumentoExiste.isEmpty()) {
			return ResponseEntity.status(422).build();
		}

		try {
			propostaRepository.save(proposta);

			AnaliseCliente.ConsultaStatusResquest consulta = new ConsultaStatusResquest(proposta.getRgCpf(),
					proposta.getNome(), proposta.getId());
			AnaliseCliente.ConsultaAnalise consultaFeita = analiseCliente.verificaProposta(consulta);
			proposta.atualizaStatus(consultaFeita.getResultadoSolicitacao());
			propostaRepository.save(proposta);

			URI uri = uriComponentsBuilder.path("/VisualizarProposta/{id}").buildAndExpand(proposta.getId()).toUri();

			Span activeSpan = tracer.activeSpan();
			activeSpan.setTag("user.email", "Lucas.Rocha@zup.com.br");
			activeSpan.setBaggageItem("user.email", "Lucas.Rocha@zup.com.br");
			activeSpan.log("meu log");
			return ResponseEntity.created(uri).build();

		} catch (HttpClientErrorException.UnprocessableEntity e) {
			return ResponseEntity.status(422).body(null);
		}
	}

	@GetMapping("/consulta/{idProposta}")
	public ResponseEntity<PropostaResponse> buscaProposta(@PathVariable("idProposta") Long id) {
		Optional<Proposta> proposta = propostaRepository.findById(id);
		if (proposta.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			PropostaResponse response = new PropostaResponse(proposta.get().getEmail(), proposta.get().getRgCpf(),
					proposta.get().getNome(), proposta.get().getEndereco(), proposta.get().getSalario(),
					proposta.get().getStatus(), proposta.get().getIdCartao());
			Span activeSpan = tracer.activeSpan();
			String userEmail = activeSpan.getBaggageItem("user.email");
			activeSpan.setBaggageItem("user.email", userEmail);
			return ResponseEntity.ok(response);

		}
	}
}
