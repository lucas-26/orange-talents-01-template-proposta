package br.com.zup.CriacaoDePropostas.controller.request;

public class ResultadoCarteira {
	
	private String resultado;
	private String id;
	
	@Deprecated
	public ResultadoCarteira() { }

	public ResultadoCarteira(String resultado, String id) {
		super();
		this.resultado = resultado;
		this.id = id;
	}

	public String getResultado() {
		return resultado;
	}

	public String getId() {
		return id;
	}
}
