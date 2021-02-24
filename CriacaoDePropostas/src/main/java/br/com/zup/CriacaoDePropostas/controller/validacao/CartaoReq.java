package br.com.zup.CriacaoDePropostas.controller.validacao;

import javax.validation.constraints.NotBlank;

import org.springframework.http.ResponseEntity;

public class CartaoReq {
	
	private String documento;
	private String nome;
	private String idProposta;
	
	public String getDocumento() {
		return documento;
	}
	public String getNome() {
		return nome;
	}
	public String getIdProposta() {
		return idProposta;
	}

	public CartaoReq() { }
	public CartaoReq(String documento, String nome, String idProposta) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
	}
	
	public static Object BloquearCartaoNoLegado(@NotBlank String idCartao, AnaliseCartao analisaCartao) {
		Sistema sistemaResponsavel = new Sistema("http://localhost:8079/BloqueiaCartao/ConsultarCartao/{idCartao}");
		ResponseEntity<?> retorno = analisaCartao.bloqueiaCartaoNoLegado(idCartao, sistemaResponsavel);
		Object valorRetorno = retorno.getBody();
		return valorRetorno;
	}
	
	
}
