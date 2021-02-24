package br.com.zup.CriacaoDePropostas.controller.validacao;

import java.time.LocalDateTime;

public class AvisarLegadoViagem {

	private String destino;
	private LocalDateTime validoAte;

	public AvisarLegadoViagem(String destino, LocalDateTime validoAte) {
		super();
		this.destino = destino;
		this.validoAte = validoAte;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDateTime getValidoAte() {
		return validoAte;
	}
}
