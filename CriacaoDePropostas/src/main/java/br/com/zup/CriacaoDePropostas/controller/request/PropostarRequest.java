package br.com.zup.CriacaoDePropostas.controller.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import br.com.zup.CriacaoDePropostas.model.Endereco;
import br.com.zup.CriacaoDePropostas.model.Proposta;

public class PropostarRequest {

	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String rgCpf;
	@NotBlank
	private String nome;
	private EnderecoRequest endereco;
	@NotNull
	@Positive
	private BigDecimal salario;

	public String getEmail() {
		return email;
	}

	public String getRgCpf() {
		return rgCpf;
	}

	public String getNome() {
		return nome;
	}

	public EnderecoRequest getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}
	
	@Deprecated
	public PropostarRequest() { }

	public PropostarRequest(@NotBlank @Email String email, @NotBlank String rgCpf, @NotBlank String nome,
			@NotBlank EnderecoRequest endereco, @NotNull @Positive BigDecimal salario) {
		super();
		this.email = email;
		this.rgCpf = rgCpf;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public boolean documentoValido() {
		Assert.hasLength(rgCpf, "O cpf ou cnpj não foi preenchido ");

		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);

		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		boolean valor = cpfValidator.isValid(rgCpf, null) || cnpjValidator.isValid(rgCpf, null);
		return valor;
	}

	public static Proposta converter(@Valid PropostarRequest propostaRequest) {
		Endereco endereco = EnderecoRequest.converter(propostaRequest.getEndereco());
		return new Proposta(propostaRequest.getEmail(), propostaRequest.getRgCpf(),propostaRequest.getNome(),
				endereco, propostaRequest.getSalario());
	}
}
