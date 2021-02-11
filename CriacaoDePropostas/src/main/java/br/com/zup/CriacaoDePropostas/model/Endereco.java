package br.com.zup.CriacaoDePropostas.model;

public class Endereco {

	private String cep;
	private Long numero;
	private String nomeRua;
	private String nomeBairro;
	private String municipio;
	
	public String getCep() {
		return cep;
	}
	public Long getNumero() {
		return numero;
	}
	public String getNomeRua() {
		return nomeRua;
	}
	public String getNomeBairro() {
		return nomeBairro;
	}
	public String getMunicipio() {
		return municipio;
	}
	
	@Deprecated
	public Endereco() {}
	
	public Endereco(String cep, Long numero, String nomeRua, String nomeBairro, String municipio) {
		super();
		this.cep = cep;
		this.numero = numero;
		this.nomeRua = nomeRua;
		this.nomeBairro = nomeBairro;
		this.municipio = municipio;
	}
}
