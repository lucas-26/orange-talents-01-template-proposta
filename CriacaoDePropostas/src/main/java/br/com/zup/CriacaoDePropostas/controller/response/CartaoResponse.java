package br.com.zup.CriacaoDePropostas.controller.response;

import java.math.BigDecimal;
import java.util.List;

public class CartaoResponse {
	private String id;
	private String emitidoEm;
	private String titular;
	private List<BloqueiosResponse> bloqueios;
	private List<String> avisos;
	private List<CarteirasResponse> carteiras;
	private List<String> parcelas;
	private BigDecimal limite;
	private String renegociacao;
	private VencimentoResponse vencimento;
	private Long idProposta;
	
	@Deprecated
	public CartaoResponse() { }
	
	public CartaoResponse(String id, String emitidoEm, String titular, List<BloqueiosResponse> bloqueios,
			List<String> avisos, List<CarteirasResponse> carteiras, List<String> parcelas, BigDecimal limite, String renegociacao,
			VencimentoResponse vencimento, Long idProposta) {
		super();
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.bloqueios = bloqueios;
		this.avisos = avisos;
		this.carteiras = carteiras;
		this.parcelas = parcelas;
		this.limite = limite;
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
		this.idProposta = idProposta;
	}
	public String getId() {
		return id;
	}
	public String getEmitidoEm() {
		return emitidoEm;
	}
	public String getTitular() {
		return titular;
	}
	public List<BloqueiosResponse> getBloqueios() {
		return bloqueios;
	}
	public List<String> getAvisos() {
		return avisos;
	}
	public List<CarteirasResponse> getCarteiras() {
		return carteiras;
	}
	public List<String> getParcelas() {
		return parcelas;
	}
	public BigDecimal getLimite() {
		return limite;
	}
	public String getRenegociacao() {
		return renegociacao;
	}
	public VencimentoResponse getVencimento() {
		return vencimento;
	}
	public Long getIdProposta() {
		return idProposta;
	}

	@Override
	public String toString() {
		return "CartaoResponse [id=" + id + ", emitidoEm=" + emitidoEm + ", titular=" + titular + ", bloqueios="
				+ bloqueios + ", avisos=" + avisos + ", carteiras=" + carteiras + ", parcelas=" + parcelas + ", limite="
				+ limite + ", renegociacao=" + renegociacao + ", vencimento=" + vencimento + ", idProposta="
				+ idProposta + "]";
	}
}
