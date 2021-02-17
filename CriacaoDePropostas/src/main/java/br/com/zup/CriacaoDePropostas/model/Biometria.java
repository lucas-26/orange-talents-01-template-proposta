package br.com.zup.CriacaoDePropostas.model;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.zup.CriacaoDePropostas.repository.PropostaRepository;

@Entity
public class Biometria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String IdCartao;
	private LocalDateTime criacaoBiometria;
	private String fingerprint;

	public String getIdCartao() {
		return IdCartao;
	}

	public LocalDateTime getCriacaoBiometria() {
		return criacaoBiometria;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	private static String GerarEmBase64(String fingerprint2) {
		String gerandoBase64 = Base64.getEncoder().encodeToString(fingerprint2.getBytes());
		return gerandoBase64;
	}

	private String Base64ConverterString(String decoded) {
		byte[] decod = Base64.getDecoder().decode(decoded.getBytes());
		String messageFinal = new String(decod);
		return messageFinal;
	}
	
	public Biometria(String idCartao, LocalDateTime criacaoBiometria, String fingerprint) {
		super();
		IdCartao = idCartao;
		this.criacaoBiometria = LocalDateTime.now();
		this.fingerprint = GerarEmBase64(fingerprint);
	}
}
