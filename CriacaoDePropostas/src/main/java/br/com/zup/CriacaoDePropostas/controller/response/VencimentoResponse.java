package br.com.zup.CriacaoDePropostas.controller.response;

public class VencimentoResponse {

	private String id;
    private Long dia;
    private String dataDeCriacao;
    
	public VencimentoResponse(String id, Long dia, String dataDeCriacao) {
		super();
		this.id = id;
		this.dia = dia;
		this.dataDeCriacao = dataDeCriacao;
	}

	public String getId() {
		return id;
	}

	public Long getDia() {
		return dia;
	}

	public String getDataDeCriacao() {
		return dataDeCriacao;
	}
}
