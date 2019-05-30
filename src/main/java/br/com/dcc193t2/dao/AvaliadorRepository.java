package br.com.dcc193t2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dcc193t2.model.Avaliador;


/**
 * AvaliadorRepository
 */
@Repository
public interface AvaliadorRepository extends JpaRepository<Long, Avaliador> {

    
}