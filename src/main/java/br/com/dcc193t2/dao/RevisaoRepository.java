package br.com.dcc193t2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dcc193t2.model.Avaliador;
import br.com.dcc193t2.model.Revisao;
import br.com.dcc193t2.model.Trabalho;

/**
 * RevisaoRepository
 */
@Repository
public interface RevisaoRepository extends JpaRepository<Revisao, Long> {

	Revisao findFirstByRefavaliadorAndReftrabalho(Avaliador avaliador, Trabalho trabalho);

    
}