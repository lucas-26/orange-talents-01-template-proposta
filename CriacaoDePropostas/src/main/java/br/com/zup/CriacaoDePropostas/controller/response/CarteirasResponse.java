package br.com.zup.CriacaoDePropostas.controller.response;

import java.time.LocalDateTime;

public class CarteirasResponse {

	private String id;
	private String email;
	private LocalDateTime associadaEm;
	private String emissor;

	public CarteirasResponse() {
	}

	public CarteirasResponse(String id, String email, LocalDateTime associadaEm, String emissor) {
		super();
		this.id = id;
		this.email = email;
		this.associadaEm = associadaEm;
		this.emissor = emissor;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getAssociadaEm() {
		return associadaEm;
	}

	public String getEmissor() {
		return emissor;
	}

}
