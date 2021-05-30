package br.com.zupacademy.luiz.transacoes.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zupacademy.luiz.transacoes.cartao.Cartao;
import br.com.zupacademy.luiz.transacoes.estabelecimento.Estabelecimento;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private BigDecimal valor;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cartao cartao;
    
    private LocalDateTime efetivadaEm = LocalDateTime.now();

    @Deprecated
    public Transacao() {}

    public Transacao(String uuid, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao) {
        this.uuid = uuid;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

	public Long getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
    
    
}
