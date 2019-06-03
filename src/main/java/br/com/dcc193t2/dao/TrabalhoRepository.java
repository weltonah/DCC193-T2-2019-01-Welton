package br.com.dcc193t2.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.dcc193t2.model.AreaConhecimento;
import br.com.dcc193t2.model.Trabalho;

/**
 * TrabalhoRepository
 */
@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

	List<Trabalho> findByAreaConhecimento(AreaConhecimento areaConhecimento);

	@Query("SELECT trab from Trabalho trab"
	+ " inner join Revisao as rev on rev.reftrabalho.id = trab.id "
	+ " inner join Avaliador as ava on rev.refavaliador.id = ava.id "
	+ " where ava.id = ?1 and trab.areaConhecimento.id = ?2 and rev.status = 1")
	List<Trabalho> findByIdAvalaliadorAndIdAreaConhecimentoOrderByStatus(Long idAvaliador, Long idArea);

}