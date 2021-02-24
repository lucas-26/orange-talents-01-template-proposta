package br.com.zup.CriacaoDePropostas.controller.request;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;

import br.com.zup.CriacaoDePropostas.controller.validacao.AnaliseCartao;
import br.com.zup.CriacaoDePropostas.controller.validacao.AvisarLegadoViagem;

public class AvisoViagemLegadoRequest {

	private String cartaoId;
	private String destinoViagem;
	private LocalDateTime dataTermino;

	public AvisoViagemLegadoRequest(String cartaoId, String destinoViagem, LocalDateTime dataTermino) {
		super();
		this.cartaoId = cartaoId;
		this.destinoViagem = destinoViagem;
		this.dataTermino = dataTermino;
	}

	public String getCartaoId() {
		return cartaoId;
	}

	public String getDestinoViagem() {
		return destinoViagem;
	}

	public LocalDateTime getDataTermino() {
		return dataTermino;
	}
	
	public ResponseEntity<?> avisaLegado(AvisoViagemLegadoRequest avisarViagemParaLegado,AnaliseCartao analiseCartao){
		AvisarLegadoViagem aviso = new AvisarLegadoViagem(avisarViagemParaLegado.getDestinoViagem(), avisarViagemParaLegado.getDataTermino());
		ResponseEntity<?> responseLegado = analiseCartao.avisaLegadoSobreViagem(avisarViagemParaLegado.getCartaoId(), aviso);
		return responseLegado;
	}
}
