package br.com.zup.CriacaoDePropostas.controller.request;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

public class AvisoViagemRequest {

	@NotBlank
	@NotNull
	@NotEmpty
	private String destinoViagem;
	@NotNull
	@Future
	private LocalDateTime dataTerminoViagem;

	@Deprecated
	public AvisoViagemRequest() {
	}

	public AvisoViagemRequest(@NotBlank @NotEmpty String destinoViagem, @Future LocalDateTime dataTerminoViagem) {
		super();
		this.destinoViagem = destinoViagem;
		this.dataTerminoViagem = dataTerminoViagem;
	}

	public String getDestinoViagem() {
		return destinoViagem;
	}

	public LocalDateTime getDataTerminoViagem() {
		return dataTerminoViagem;
	}
}
