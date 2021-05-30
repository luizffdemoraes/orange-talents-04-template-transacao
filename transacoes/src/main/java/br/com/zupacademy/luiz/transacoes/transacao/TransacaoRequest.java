package br.com.zupacademy.luiz.transacoes.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.luiz.transacoes.estabelecimento.EstabelecimentoResponse;

public class TransacaoRequest {
	
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoResponse estabelecimento;
	
    public TransacaoRequest(BigDecimal valor, LocalDateTime efetivadaEm, EstabelecimentoResponse estabelecimento) {
		this.valor = valor;
		this.efetivadaEm = efetivadaEm;
		this.estabelecimento = estabelecimento;
	}
	



}
