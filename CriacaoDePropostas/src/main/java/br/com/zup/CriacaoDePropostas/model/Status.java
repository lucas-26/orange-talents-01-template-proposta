package br.com.zup.CriacaoDePropostas.model;

public enum Status {
	NAO_ELEGIVEL, ELEGIVEL;

	public static Status resultadoPara(String resultadoSolicitacao) {
		if(resultadoSolicitacao.equals("COM_RESTRICAO")) {
				return NAO_ELEGIVEL;
		}
		return ELEGIVEL;
	}
}
