package br.com.zup.CriacaoDePropostas.controller.validacao;

public class CartaoParaCarteira {
		  
	private String email;
	private String carteira;
	
	public String getEmail() {
		return email;
	}
	public String getCarteira() {
		return carteira;
	}
	@Deprecated
	public CartaoParaCarteira() { }
	public CartaoParaCarteira(String email, String carteira) {
		super();
		this.email = email;
		this.carteira = carteira;
	}
}
