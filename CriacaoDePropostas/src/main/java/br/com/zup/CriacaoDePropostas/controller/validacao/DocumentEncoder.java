package br.com.zup.CriacaoDePropostas.controller.validacao;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DocumentEncoder {
	
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
	
	public static String GerarHash(String documento) {
		String documentoHash = encoder.encode(documento);
		return documentoHash;
	}
}
