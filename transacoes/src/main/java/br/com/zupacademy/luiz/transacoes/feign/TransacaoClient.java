package br.com.zupacademy.luiz.transacoes.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.zupacademy.luiz.transacoes.cartao.CartaoRequest;
import br.com.zupacademy.luiz.transacoes.cartao.CartaoResponse;

@FeignClient(name = "transacao", url = "${transacao.client.url}")
public interface TransacaoClient {

	@PostMapping
    CartaoResponse ativaTransacao(@RequestBody CartaoRequest request);

    @DeleteMapping("/{idCartao}")
    void paraTransacao(@PathVariable String idCartao);
	
}
