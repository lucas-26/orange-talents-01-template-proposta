package br.com.zup.CriacaoDePropostas.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	@Column(unique = true)
	private String rgCpf;
	private String nome;
	@Embedded
	private Endereco endereco;
	private BigDecimal salario;
	@Enumerated(EnumType.STRING)
	private Status status;
	@Column(unique = true)
	private String IdCartao;
	
	
	public Long getId() {
		return id;
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

	public void InsereIdCartao(String idCartao) {
		IdCartao = idCartao;
	}

	@Deprecated
	public Proposta() { }

	public Proposta(String email, String rgCpf, String nome, Endereco endereco, BigDecimal salario) {
		super();
		this.email = email;
		this.rgCpf = rgCpf;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return " "+ getId() + " " + getNome() + " " + getRgCpf() + " ";
	}

	public void atualizaStatus(String resultadoSolicitacao) {
		this.status = Status.resultadoPara(resultadoSolicitacao);
		
	}
}
