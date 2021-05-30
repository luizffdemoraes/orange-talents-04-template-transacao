package br.com.zupacademy.luiz.transacoes.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import br.com.zupacademy.luiz.transacoes.cartao.Cartao;
import br.com.zupacademy.luiz.transacoes.estabelecimento.Estabelecimento;

@Entity
public class Transacao {

	@Id
    private String id;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cartao cartao;

    @CreationTimestamp
    private LocalDateTime instante = LocalDateTime.now();
   
    @Deprecated
    public Transacao() {
    }

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

	public String getId() {
		return id;
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

	public LocalDateTime getInstante() {
		return instante;
	}

	
    
    
}
