package br.com.zup.CriacaoDePropostas.controller.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.http.ResponseEntity;

import com.sun.istack.NotNull;

import br.com.zup.CriacaoDePropostas.controller.validacao.AnaliseCartao;
import br.com.zup.CriacaoDePropostas.controller.validacao.CartaoParaCarteira;
import br.com.zup.CriacaoDePropostas.model.AssociarCartao;
import br.com.zup.CriacaoDePropostas.model.Cartao;

public class AssociarCartaoRequest {
	
	@NotBlank
	@NotNull
	@NotEmpty
	@Email
	private String email;
	@NotBlank
	@NotEmpty
	@NotNull
	private String carteira;
	
	public String getEmail() {
		return email;
	}
	public String getCarteira() {
		return carteira;
	}
	
	@Deprecated
	public AssociarCartaoRequest() {}
	
	public AssociarCartaoRequest(@NotBlank @NotEmpty @Email String email, @NotBlank @NotEmpty String carteira) {
		super();
		this.email = email;
		this.carteira = carteira;
	}
	
	public ResponseEntity<ResultadoCarteira> AssociarCartaParaUmaCarteira(String id, AssociarCartaoRequest cartao, AnaliseCartao analiseCartao) {
		CartaoParaCarteira associarNoServico = new CartaoParaCarteira(cartao.getCarteira(), cartao.getEmail());
		ResponseEntity<ResultadoCarteira> retorno = analiseCartao.associarCartao(id, associarNoServico);
		return retorno;
	}
	public AssociarCartao converteRequestParaCartao(String id, String id2, String email2, String resultado, String carteira2) {
		return new AssociarCartao(id, id2, email2, resultado, carteira2);
	}
}
