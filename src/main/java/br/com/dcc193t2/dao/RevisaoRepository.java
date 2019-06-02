package br.com.dcc193t2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

	@Query("SELECT rev from Revisao rev"
	+ " inner join Avaliador as ava on rev.refavaliador.id = ava.id "
	+ " where ava.id = ?1 and rev.status = 1")
	List<Revisao> findByRefavaliador(Long long1);

    
}