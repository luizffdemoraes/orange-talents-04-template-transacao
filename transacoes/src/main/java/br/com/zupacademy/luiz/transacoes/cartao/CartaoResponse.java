package br.com.zupacademy.luiz.transacoes.cartao;

public class CartaoResponse {

	private String id;
	private String email;

	@Deprecated
	public CartaoResponse() {
	}

	public CartaoResponse(Cartao cartao) {
		this.id = cartao.getIdCartao();
		this.email = cartao.getEmail();
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
}
