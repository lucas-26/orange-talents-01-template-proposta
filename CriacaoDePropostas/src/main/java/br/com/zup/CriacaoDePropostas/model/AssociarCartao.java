package br.com.zup.CriacaoDePropostas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AssociarCartao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cartaoId;
	private String carteirasId;
	private String email;
	private String carteira;
	private String carteiraAssociado;
	
	@Deprecated
	public AssociarCartao() {}

	public AssociarCartao(String cartaoId, String carteirasId, String email, String carteira,
			String carteiraAssociado) {
		super();
		this.cartaoId = cartaoId;
		this.carteirasId = carteirasId;
		this.email = email;
		this.carteira = carteira;
		this.carteiraAssociado = carteiraAssociado;
	}

	public Long getId() {
		return id;
	}

	public String getCartaoId() {
		return cartaoId;
	}

	public String getCarteirasId() {
		return carteirasId;
	}

	public String getEmail() {
		return email;
	}

	public String getCarteira() {
		return carteira;
	}

	public String getCarteiraAssociado() {
		return carteiraAssociado;
	}
}
