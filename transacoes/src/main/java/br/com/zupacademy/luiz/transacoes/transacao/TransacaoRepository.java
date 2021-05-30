package br.com.zupacademy.luiz.transacoes.transacao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {

	List<Transacao> findFirst10ByCartaoIdOrderByInstanteDesc(String id);
    
}


