package br.com.zupacademy.luiz.transacoes.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class ListenerDeTransacao {

    private final Logger log = LoggerFactory.getLogger(ListenerDeTransacao.class);
    private final TransacaoRepository transacaoRepository;

    public ListenerDeTransacao(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoResponse eventoDeTransacao) {
    	log.info("Inicia transação!");
        log.info(eventoDeTransacao.getId());
        log.info(eventoDeTransacao.getValor().toString());
        log.info(eventoDeTransacao.getCartao().getId());
        log.info(eventoDeTransacao.getEstabelecimento().getNome());
        log.info("Fim da transação!");
        transacaoRepository.save(eventoDeTransacao.toModel());
        log.info("Nova transação salva {}", eventoDeTransacao.toString());
    }
} 
