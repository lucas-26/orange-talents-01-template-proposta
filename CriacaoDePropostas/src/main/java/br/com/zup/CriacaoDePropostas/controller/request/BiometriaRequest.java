package br.com.zup.CriacaoDePropostas.controller.request;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zup.CriacaoDePropostas.model.Biometria;

public class BiometriaRequest {

	@NotNull
	@NotBlank
	private String fingerprint;


	public String getFingerprint() {
		return fingerprint;
	}

	public BiometriaRequest(@NotBlank String fingerprint) {
		this.fingerprint = fingerprint;
	}

	@Deprecated
	public BiometriaRequest() {}
	
	public static Biometria ConverteParaBiometria(String idCartao, @Valid BiometriaRequest biometriaRequest) {
		return new Biometria(idCartao, LocalDateTime.now(), biometriaRequest.getFingerprint());
	}
}
