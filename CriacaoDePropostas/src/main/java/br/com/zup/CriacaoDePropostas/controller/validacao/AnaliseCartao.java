package br.com.zup.CriacaoDePropostas.controller.validacao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.zup.CriacaoDePropostas.controller.response.CartaoResponse;

@FeignClient(name = "analiseCartao", url = "http://localhost:8888/api")
public interface AnaliseCartao {

	@RequestMapping(method = RequestMethod.GET, value = "/cartoes?idProposta={idProposta}")
	CartaoResponse verificaSePropostatemCartao(@PathVariable("idProposta") String idProposta);

}
