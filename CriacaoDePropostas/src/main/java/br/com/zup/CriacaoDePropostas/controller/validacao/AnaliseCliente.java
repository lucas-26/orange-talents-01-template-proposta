package br.com.zup.CriacaoDePropostas.controller.validacao;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "analiseCliente", url = "http://localhost:9999/api/solicitacao")
public interface AnaliseCliente {

	@PostMapping
	ConsultaAnalise verificaProposta(@RequestBody ConsultaStatusResquest ConsultaStatus);

	class ConsultaStatusResquest {
		private String documento;
		private String nome;
		private Long idProposta;

		public ConsultaStatusResquest(String documento, String nome, Long idProposta) {
			super();
			this.documento = documento;
			this.nome = nome;
			this.idProposta = idProposta;
		}

		public String getDocumento() {
			return documento;
		}

		public String getNome() {
			return nome;
		}

		public Long getIdProposta() {
			return idProposta;
		}

	}

	class ConsultaAnalise {

		private String documento;
		private String nome;
		private String resultadoSolicitacao;
		private Long idProposta;

		public String getDocumento() {
			return documento;
		}

		public String getNome() {
			return nome;
		}

		public String getResultadoSolicitacao() {
			return resultadoSolicitacao;
		}

		public Long getIdProposta() {
			return idProposta;
		}

		public ConsultaAnalise(String documento, String nome, String resultadoSolicitacao, Long idProposta) {
			super();
			this.documento = documento;
			this.nome = nome;
			this.resultadoSolicitacao = resultadoSolicitacao;
			this.idProposta = idProposta;
		}
	}
}
