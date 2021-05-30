package br.com.zupacademy.luiz.transacoes.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Cartao {

	@Id
	private String idCartao;

	@Email
	private String email;

	@Deprecated
	public Cartao() {
	}

	public Cartao(String idCartao, String email) {
		this.idCartao = idCartao;
		this.email = email;
	}

	public String getIdCartao() {
		return idCartao;
	}

	public String getEmail() {
		return email;
	}

}
