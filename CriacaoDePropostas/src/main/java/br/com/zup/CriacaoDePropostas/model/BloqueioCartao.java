package br.com.zup.CriacaoDePropostas.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BloqueioCartao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cartaoId;
	private LocalDateTime instanteBloqueio;
	private String ipCliente;
	private String userAgent;
	
	public Long getId() {
		return id;
	}
	public String getCartaoId() {
		return cartaoId;
	}
	public LocalDateTime getInstanteBloqueio() {
		return instanteBloqueio;
	}
	public String getIpCliente() {
		return ipCliente;
	}
	public String getUserAgent() {
		return userAgent;
	}
	
	@Deprecated
	public BloqueioCartao() {	}
	
	public BloqueioCartao(String cartaoId, String ipCliente, String userAgent) {
		super();
		this.cartaoId = cartaoId;
		this.instanteBloqueio = LocalDateTime.now();
		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
	}
}
