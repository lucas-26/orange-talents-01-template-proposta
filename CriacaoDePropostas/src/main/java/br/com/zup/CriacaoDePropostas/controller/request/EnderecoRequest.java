package br.com.zup.CriacaoDePropostas.controller.request;

import javax.validation.constraints.NotNull;

import br.com.zup.CriacaoDePropostas.model.Endereco;

public class EnderecoRequest {

	@NotNull
	private String cep;
	@NotNull
	private Long numero;
	@NotNull
	private String nomeRua;
	@NotNull
	private String nomeBairro;
	@NotNull
	private String municipio;

	public String getCep() {
		return cep;
	}

	public Long getNumero() {
		return numero;
	}

	public String getNomeRua() {
		return nomeRua;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public static Endereco converter(EnderecoRequest enderecoRequest) {
		return new Endereco(enderecoRequest.getCep(), enderecoRequest.getNumero(), enderecoRequest.getNomeRua(),
				enderecoRequest.getNomeBairro(), enderecoRequest.getMunicipio());
	}
}
