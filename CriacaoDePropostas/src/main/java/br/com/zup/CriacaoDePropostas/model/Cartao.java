package br.com.zup.CriacaoDePropostas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cartaoId;
	private String titular;

	public Cartao(String cartaoId,String titular) {
		super();
		this.cartaoId = cartaoId;
		this.titular = titular;
	}

	@Deprecated
	public Cartao() {
	}

	public Long getId() {
		return id;
	}

	public String getCartaoId() {
		return cartaoId;
	}

	public String getTitular() {
		return titular;
	}

}
