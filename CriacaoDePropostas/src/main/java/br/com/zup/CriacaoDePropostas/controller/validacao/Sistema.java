package br.com.zup.CriacaoDePropostas.controller.validacao;

public class Sistema {

	private String sistemaResponsavel;
	
	@Deprecated
	public Sistema() {	}

	public Sistema(String sistemaResponsavel) {
		super();
		this.sistemaResponsavel = sistemaResponsavel;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}
}
