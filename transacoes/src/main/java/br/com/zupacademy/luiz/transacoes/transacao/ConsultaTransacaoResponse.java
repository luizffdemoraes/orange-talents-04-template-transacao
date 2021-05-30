package br.com.zupacademy.luiz.transacoes.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConsultaTransacaoResponse {
    private String id;
    private BigDecimal valor;
    private String estabelecimento;
    private String cartao;
    private LocalDateTime instante;

    @Deprecated
    public ConsultaTransacaoResponse() {
    }

    public ConsultaTransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.estabelecimento = transacao.getEstabelecimento().getNome();
        this.cartao = transacao.getCartao().getId();
        this.instante = transacao.getInstante();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public String getCartao() {
        return cartao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

}
