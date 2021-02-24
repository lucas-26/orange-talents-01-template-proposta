package br.com.zup.CriacaoDePropostas.controller.response;

public class BloqueiosResponse {

	private String id;
	private String bloqueadoEm;
	private String sistemaResponsavel;
	private String ativo;

	@Deprecated
	public BloqueiosResponse() {}
	
	public BloqueiosResponse(String id, String bloqueadoEm, String sistemaResponsavel, String ativo) {
		super();
		this.id = id;
		this.bloqueadoEm = bloqueadoEm;
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;
	}

	public String getId() {
		return id;
	}

	public String getBloqueadoEm() {
		return bloqueadoEm;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

	public String getAtivo() {
		return ativo;
	}
}
