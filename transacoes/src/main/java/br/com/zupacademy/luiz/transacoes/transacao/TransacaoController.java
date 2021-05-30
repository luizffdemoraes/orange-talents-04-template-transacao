package br.com.zupacademy.luiz.transacoes.transacao;

import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.zupacademy.luiz.transacoes.cartao.CartaoRequest;
import br.com.zupacademy.luiz.transacoes.cartao.CartaoResponse;
import br.com.zupacademy.luiz.transacoes.feign.TransacaoClient;

import javax.validation.Valid;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
	
	private final Logger log = LoggerFactory.getLogger(TransacaoController.class);
    private final TransacaoClient transacaoClient;

    public TransacaoController(TransacaoClient transacaoClient) {
        this.transacaoClient = transacaoClient;
    }

    @PostMapping
    public ResponseEntity inicia(@RequestBody @Valid CartaoRequest request) {
        try {
            CartaoResponse cartao = transacaoClient.ativaTransacao(request);
            return ResponseEntity.ok().body(cartao);

        } catch (FeignException.FeignServerException | FeignException.FeignClientException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public void paraTransacao(@PathVariable String id) {
        try {
            transacaoClient.paraTransacao(id);
            log.info("Transação interrompida para o cartão {}", id);
        } catch (FeignException ex) {
            log.warn("Não foi possível parar esta transação...");
            ex.printStackTrace();
        }
    }
	

}
