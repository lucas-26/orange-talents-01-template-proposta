package br.com.zup.CriacaoDePropostas.controller.response;

import java.math.BigDecimal;

import br.com.zup.CriacaoDePropostas.model.Endereco;
import br.com.zup.CriacaoDePropostas.model.Status;

public class PropostaResponse {

	private String email;
	private String rgCpf;
	private String nome;
	private Endereco endereco;
	private BigDecimal salario;
	private Status status;
	private String IdCartao;

	public PropostaResponse(String email, String rgCpf, String nome, Endereco endereco, BigDecimal salario,
			Status status, String idCartao) {
		super();
		this.email = email;
		this.rgCpf = rgCpf;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.status = status;
		IdCartao = idCartao;
	}

	public String getEmail() {
		return email;
	}

	public String getRgCpf() {
		return rgCpf;
	}

	public String getNome() {
		return nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public Status getStatus() {
		return status;
	}

	public String getIdCartao() {
		return IdCartao;
	}
}
