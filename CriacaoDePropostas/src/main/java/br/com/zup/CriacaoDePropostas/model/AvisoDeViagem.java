package br.com.zup.CriacaoDePropostas.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AvisoDeViagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cartaoId;
	private String destinoViagem;
	private LocalDateTime dataTerminoViagem;
	private LocalDateTime instanteAvisoViagem;
	private String ipCliente;
	private String UserAgent;

	@Deprecated
	public AvisoDeViagem() {
	}

	public AvisoDeViagem(String cartaoId, String destinoViagem, LocalDateTime dataTerminoViagem,
			String ipCliente, String userAgent) {
		super();
		this.cartaoId = cartaoId;
		this.destinoViagem = destinoViagem;
		this.dataTerminoViagem = dataTerminoViagem;
		this.instanteAvisoViagem = LocalDateTime.now();
		this.ipCliente = ipCliente;
		UserAgent = userAgent;
	}

	public String getCartaoId() {
		return cartaoId;
	}

	public String getDestinoViagem() {
		return destinoViagem;
	}

	public LocalDateTime getDataTerminoViagem() {
		return dataTerminoViagem;
	}

	public LocalDateTime getInstanteAvisoViagem() {
		return instanteAvisoViagem;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public String getUserAgent() {
		return UserAgent;
	}
}
