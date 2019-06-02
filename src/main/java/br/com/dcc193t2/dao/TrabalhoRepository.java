package br.com.dcc193t2.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dcc193t2.model.AreaConhecimento;
import br.com.dcc193t2.model.Trabalho;

/**
 * TrabalhoRepository
 */
@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

	List<Trabalho>  findByAreaConhecimento(AreaConhecimento areaConhecimento);

    
}