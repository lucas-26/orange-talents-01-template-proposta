package br.com.zup.CriacaoDePropostas.controller.validacao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.zup.CriacaoDePropostas.controller.request.ResultadoCarteira;
import br.com.zup.CriacaoDePropostas.controller.response.CartaoResponse;
import feign.Headers;

@FeignClient(name = "analiseCartao", url = "http://localhost:8888/api")
public interface AnaliseCartao {

	@RequestMapping(method = RequestMethod.GET, value = "/cartoes?idProposta={idProposta}")
	CartaoResponse verificaSePropostatemCartao(@PathVariable("idProposta") String idProposta);

	@RequestMapping(method = RequestMethod.POST, value = "/cartoes")
	@Headers("Content-Type: application/json")
	ResponseEntity<?> getNumeroCartao(@RequestBody CartaoReq cartao);

	@RequestMapping(method = RequestMethod.POST, value = "/cartoes/{id}/bloqueios")
	@Headers("Content-Type: application/json")
	ResponseEntity<?> bloqueiaCartaoNoLegado(@PathVariable("id") String id, @RequestBody Sistema sistemaResponsavel);

	@RequestMapping(method = RequestMethod.POST, value = "/cartoes/{id}/avisos")
	@Headers("Content-Type: application/json")
	ResponseEntity<?> avisaLegadoSobreViagem(@PathVariable("id") String id, @RequestBody AvisarLegadoViagem avisaViagem);
	
	@RequestMapping(method = RequestMethod.POST, value = "/cartoes/{id}/carteiras")
	@Headers("Content-Type: application/json")
	ResponseEntity<ResultadoCarteira> associarCartao(@PathVariable("id") String id, @RequestBody CartaoParaCarteira cartaoParaCarteira);
}
