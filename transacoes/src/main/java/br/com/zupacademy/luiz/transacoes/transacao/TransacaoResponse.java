package br.com.zupacademy.luiz.transacoes.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.luiz.transacoes.cartao.Cartao;
import br.com.zupacademy.luiz.transacoes.cartao.CartaoRequest;
import br.com.zupacademy.luiz.transacoes.cartao.CartaoResponse;
import br.com.zupacademy.luiz.transacoes.estabelecimento.Estabelecimento;
import br.com.zupacademy.luiz.transacoes.estabelecimento.EstabelecimentoRequest;
import br.com.zupacademy.luiz.transacoes.estabelecimento.EstabelecimentoResponse;

public class TransacaoResponse {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoRequest estabelecimento;
    private CartaoRequest cartao;

    @Deprecated
    public TransacaoResponse() {
    }

    public TransacaoResponse(String id, BigDecimal valor, EstabelecimentoRequest estabelecimento, CartaoRequest cartao) {
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

    public EstabelecimentoRequest getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoRequest getCartao() {
        return cartao;
    }



    public Transacao toModel(){
        return new Transacao(id, valor, estabelecimento.toModel(), cartao.toModel());
    }
    
}
