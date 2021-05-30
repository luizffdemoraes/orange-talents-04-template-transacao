package br.com.zupacademy.luiz.transacoes.cartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoRequest {

	@NotBlank
	private String id;

	@Email
	@NotBlank
	private String email;

	@Deprecated
	public CartaoRequest() {
	}

	public CartaoRequest(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Cartao toModel() {
		return new Cartao(this.id, this.email);
	}

}
